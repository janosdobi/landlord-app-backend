package home.dj.persistence

import home.dj.domain.*
import home.dj.jooq.model.enums.CostCategory
import home.dj.jooq.model.sequences.INVOICES_ID_SEQ
import home.dj.jooq.model.tables.*
import home.dj.jooq.model.tables.references.*
import jakarta.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.NoResultException
import home.dj.domain.CostCategory as InternalCostCategory
import home.dj.domain.UserRole as InternalUserRole

interface DatabaseService {
    suspend fun getCredentialAndIdForUser(userName: String): Pair<String, Int>
    suspend fun getUserRoles(uid: Int): List<InternalUserRole>
    suspend fun fetchAgreementForUser(agreementId: Long, uid: Int, role: InternalUserRole): Agreement
    suspend fun persistInvoiceWithCosts(
        utilityInvoice: UtilityInvoice,
        allocatedCosts: List<AllocatedCost>,
        userName: String
    )

    suspend fun getCostsForPeriod(startDate: LocalDate, endDate: LocalDate, agreementId: Long): List<AllocatedCost>
}

@Singleton
class DefaultDatabaseService(
    private val context: DSLContext,
    private val dispatcher: CoroutineDispatcher
) : DatabaseService {
    override suspend fun getCredentialAndIdForUser(userName: String): Pair<String, Int> =
        withContext(dispatcher) {
            context.select(
                UserCredentials.USER_CREDENTIALS.CREDENTIAL,
                Users.USERS.ID
            )
                .from(USERS)
                .join(USER_CREDENTIALS).on(USER_CREDENTIALS.USER_ID.eq(USERS.ID))
                .where(Users.USERS.NAME.eq(userName))
                .fetchOne()
                ?.let {
                    it[UserCredentials.USER_CREDENTIALS.CREDENTIAL]!! to it[Users.USERS.ID]!!
                } ?: ("" to -1)
        }

    override suspend fun getUserRoles(uid: Int): List<InternalUserRole> =
        withContext(dispatcher) {
            context.select(
                UserRoles.USER_ROLES.ROLE_NAME
            )
                .from(USER_ROLES)
                .where(USER_ROLES.USER_ID.eq(uid))
                .fetch().map { InternalUserRole.valueOf(it[UserRoles.USER_ROLES.ROLE_NAME]?.name ?: "") }
        }

    override suspend fun fetchAgreementForUser(agreementId: Long, uid: Int, role: InternalUserRole): Agreement =
        withContext(dispatcher) {
            context.select(
                Agreements.AGREEMENTS.LANDLORD_ID,
                Agreements.AGREEMENTS.TENANT_ID,
                Agreements.AGREEMENTS.ID,
                Agreements.AGREEMENTS.START_DATE,
                Agreements.AGREEMENTS.END_DATE,
                Agreements.AGREEMENTS.MILESTONE_DAY,
                Agreements.AGREEMENTS.RENT_AMOUNT,
                Agreements.AGREEMENTS.RENT_CURRENCY,
                Agreements.AGREEMENTS.UTILITY_AMOUNT,
                Agreements.AGREEMENTS.UTILITY_CURRENCY,
                Agreements.AGREEMENTS.MILESTONE_DAY,
            )
                .from(AGREEMENTS)
                .where(Agreements.AGREEMENTS.ID.eq(agreementId.toInt()))
                .and(
                    if (role == InternalUserRole.LANDLORD) Agreements.AGREEMENTS.LANDLORD_ID.eq(uid)
                    else Agreements.AGREEMENTS.TENANT_ID.eq(uid)
                )
                .fetchOne()?.let {
                    Agreement(
                        id = it[Agreements.AGREEMENTS.ID]!!.toLong(),
                        landlordId = it[Agreements.AGREEMENTS.LANDLORD_ID]!!,
                        tenantId = it[Agreements.AGREEMENTS.TENANT_ID]!!,
                        startDate = it[Agreements.AGREEMENTS.START_DATE]!!.toLocalDate(),
                        endDate = it[Agreements.AGREEMENTS.END_DATE]?.toLocalDate(),
                        rentAgreement = RentAgreement(
                            amount = it[Agreements.AGREEMENTS.RENT_AMOUNT]!!.toDouble(),
                            currency = it[Agreements.AGREEMENTS.RENT_CURRENCY]!!
                        ),
                        utilityAgreement = UtilityAgreement(
                            amount = it[Agreements.AGREEMENTS.UTILITY_AMOUNT]!!.toDouble(),
                            currency = it[Agreements.AGREEMENTS.UTILITY_CURRENCY]!!
                        ),
                        milestoneDay = it[Agreements.AGREEMENTS.MILESTONE_DAY]!!
                    )
                } ?: throw NoResultException("Agreement $agreementId does not exist for landlord $uid")
        }

    override suspend fun persistInvoiceWithCosts(
        utilityInvoice: UtilityInvoice,
        allocatedCosts: List<AllocatedCost>,
        userName: String
    ) {
        withContext(dispatcher) {
            context.transaction { tx ->
                tx.dsl().insertInto(INVOICES)
                    .columns(
                        INVOICES.AMOUNT,
                        INVOICES.START_DATE,
                        INVOICES.END_DATE,
                        INVOICES.AGREEMENT_ID,
                        INVOICES.COST_CATEGORY,
                        INVOICES.FILE_NAME,
                        INVOICES.FILE_CONTENT,
                        INVOICES.CREATED_AT,
                        INVOICES.UPDATED_AT,
                        INVOICES.CREATED_BY
                    )
                    .values(
                        BigDecimal.valueOf(utilityInvoice.amount),
                        utilityInvoice.startDate.atStartOfDay(),
                        utilityInvoice.endDate.atStartOfDay(),
                        utilityInvoice.agreementId.toInt(),
                        CostCategory.valueOf(utilityInvoice.costCategory.name),
                        utilityInvoice.invoiceDocument.fileName,
                        utilityInvoice.invoiceDocument.fileContent,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        userName
                    ).execute()
                val invoiceId = tx.dsl().fetchValue(INVOICES_ID_SEQ.currval())!!.toInt()
                tx.dsl().batch(
                    allocatedCosts.map { allocatedCost ->
                        tx.dsl().insertInto(COSTS)
                            .columns(
                                COSTS.AGREEMENT_ID,
                                COSTS.INVOICE_ID,
                                COSTS.AMOUNT,
                                COSTS.COST_CATEGORY,
                                COSTS.START_DATE,
                                COSTS.END_DATE,
                                COSTS.CREATED_AT,
                                COSTS.UPDATED_AT,
                                COSTS.CREATED_BY
                            )
                            .values(
                                allocatedCost.agreementId.toInt(),
                                invoiceId,
                                BigDecimal.valueOf(allocatedCost.amount),
                                CostCategory.valueOf(allocatedCost.costCategory.name),
                                allocatedCost.startDate.atStartOfDay(),
                                allocatedCost.endDate.atStartOfDay(),
                                LocalDateTime.now(),
                                LocalDateTime.now(),
                                userName
                            )
                    }.toList()
                ).execute()
            }
        }
    }

    override suspend fun getCostsForPeriod(
        startDate: LocalDate,
        endDate: LocalDate,
        agreementId: Long
    ): List<AllocatedCost> {
        return withContext(dispatcher) {
            context.select(
                Costs.COSTS.ID,
                Costs.COSTS.AMOUNT,
                Costs.COSTS.COST_CATEGORY,
                Costs.COSTS.START_DATE,
                Costs.COSTS.END_DATE,
                Costs.COSTS.AGREEMENT_ID,
                Costs.COSTS.INVOICE_ID,
            )
                .from(COSTS)
                .where(COSTS.AGREEMENT_ID.eq(agreementId.toInt()))
                .and(COSTS.START_DATE.greaterOrEqual(startDate.atStartOfDay()))
                .and(COSTS.END_DATE.lessOrEqual(endDate.atStartOfDay()))
                .orderBy(COSTS.END_DATE)
                .fetch().map {
                    AllocatedCost(
                        id = it[Costs.COSTS.AMOUNT]!!.toLong(),
                        amount = it[Costs.COSTS.AMOUNT]!!.toDouble(),
                        costCategory = InternalCostCategory.valueOf(it[Costs.COSTS.COST_CATEGORY]!!.name),
                        startDate = it[Costs.COSTS.START_DATE]!!.toLocalDate(),
                        endDate = it[Costs.COSTS.END_DATE]!!.toLocalDate(),
                        agreementId = agreementId,
                        invoiceId = it[Costs.COSTS.INVOICE_ID]!!.toLong()
                    )
                }
        }
    }
}
