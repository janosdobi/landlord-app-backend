package home.dj.service

import home.dj.domain.AggregatedCosts
import home.dj.domain.Agreement
import home.dj.domain.DailyCost
import home.dj.domain.UtilityInvoice
import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context
import mu.KotlinLogging
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.streams.asSequence

@Context
class CostService(
    private val dbService: DatabaseService
) {

    private val logger = KotlinLogging.logger {}

    fun splitToDailyCosts(utilityInvoice: UtilityInvoice, agreement: Agreement): Sequence<DailyCost> {
        val dailyCost =
            utilityInvoice.amount.div(
                ChronoUnit.DAYS.between(
                    utilityInvoice.startDate,
                    utilityInvoice.endDate.plusDays(1)
                )
            )

        return utilityInvoice.startDate.datesUntil(utilityInvoice.endDate.plusDays(1)).map {
            DailyCost(
                amount = dailyCost,
                costCategory = utilityInvoice.costCategory,
                date = it,
                agreementId = agreement.id.toInt()
            )
        }.asSequence()
    }

    suspend fun getCostsForPeriod(startDate: LocalDate, endDate: LocalDate, agreement: Agreement): AggregatedCosts? {
        val dailyCosts = dbService.getCostsForPeriod(startDate, endDate, agreement.id.toInt())

        logger.info { dailyCosts }
        TODO("aggregation logic")
    }
}
