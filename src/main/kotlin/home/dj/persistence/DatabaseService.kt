package home.dj.persistence

import home.dj.domain.*
import home.dj.jooq.model.enums.CostCategory
import home.dj.jooq.model.tables.*
import home.dj.jooq.model.tables.references.*
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Requires
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.NoResultException
import home.dj.domain.CostCategory as InternalCostCategory
import home.dj.domain.UserRole as InternalUserRole

@Context
@Requires(notEnv = ["test"])
class DatabaseService(
    private val context: DSLContext
) {
    suspend fun getCredentialAndIdForUser(userName: String): Pair<String, Int> =
        withContext(Dispatchers.IO) {
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

    suspend fun getUserRoles(uid: Int): List<InternalUserRole> =
        withContext(Dispatchers.IO) {
            context.select(
                UserRoles.USER_ROLES.ROLE_NAME
            )
                .from(USER_ROLES)
                .where(USER_ROLES.USER_ID.eq(uid))
                .fetch().map { InternalUserRole.valueOf(it[UserRoles.USER_ROLES.ROLE_NAME]?.name ?: "") }
        }

    suspend fun fetchAgreementForUser(agreementId: Int, uid: Int, role: InternalUserRole): Agreement =
        withContext(Dispatchers.IO) {
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
                .where(Agreements.AGREEMENTS.ID.eq(agreementId))
                .and(
                    if (role == InternalUserRole.LANDLORD) Agreements.AGREEMENTS.LANDLORD_ID.eq(uid) else Agreements.AGREEMENTS.TENANT_ID.eq(
                        uid
                    )
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
                            currency = Currency.getInstance(it[Agreements.AGREEMENTS.RENT_CURRENCY]!!)
                        ),
                        utilityAgreement = UtilityAgreement(
                            amount = it[Agreements.AGREEMENTS.UTILITY_AMOUNT]!!.toDouble(),
                            currency = Currency.getInstance(it[Agreements.AGREEMENTS.UTILITY_CURRENCY]!!)
                        ),
                        milestoneDay = it[Agreements.AGREEMENTS.MILESTONE_DAY]!!
                    )
                } ?: throw NoResultException("Agreement $agreementId does not exist for landlord $uid")
        }

    suspend fun persistInvoiceWithCosts(
        utilityInvoice: UtilityInvoice,
        dailyCosts: Sequence<DailyCost>,
        userName: String
    ) {
        withContext(Dispatchers.IO) {
            context.transaction { tx ->
                tx.dsl().batch(
                    dailyCosts.map { dailyCost ->
                        tx.dsl().insertInto(COSTS)
                            .columns(
                                COSTS.AGREEMENT_ID,
                                COSTS.AMOUNT,
                                COSTS.COST_CATEGORY,
                                COSTS.COST_DATE,
                                COSTS.CREATED_AT,
                                COSTS.UPDATED_AT,
                                COSTS.CREATED_BY
                            )
                            .values(
                                dailyCost.agreementId,
                                BigDecimal.valueOf(dailyCost.amount),
                                CostCategory.valueOf(dailyCost.costCategory.name),
                                dailyCost.date.atStartOfDay(),
                                LocalDateTime.now(),
                                LocalDateTime.now(),
                                userName
                            )
                    }.toList()
                ).execute()

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
                        utilityInvoice.agreementId,
                        CostCategory.valueOf(utilityInvoice.costCategory.name),
                        utilityInvoice.fileName,
                        utilityInvoice.fileContent,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        userName
                    ).execute()
            }
        }
    }

    suspend fun getCostsForPeriod(startDate: LocalDate, endDate: LocalDate, agreementId: Int): List<DailyCost> {
        return withContext(Dispatchers.IO) {
            context.select(
                Costs.COSTS.AMOUNT,
                Costs.COSTS.COST_CATEGORY,
                Costs.COSTS.COST_DATE,
                Costs.COSTS.AGREEMENT_ID
            )
                .from(COSTS)
                .where(COSTS.AGREEMENT_ID.eq(agreementId))
                .and(COSTS.COST_DATE.between(startDate.atStartOfDay(), endDate.atStartOfDay()))
                .fetch().map {
                    DailyCost(
                        amount = it[Costs.COSTS.AMOUNT]!!.toDouble(),
                        costCategory = InternalCostCategory.valueOf(it[Costs.COSTS.COST_CATEGORY]!!.name),
                        date = it[Costs.COSTS.COST_DATE]!!.toLocalDate(),
                        agreementId = agreementId
                    )
                }
        }
    }
}
