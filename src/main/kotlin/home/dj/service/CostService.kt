package home.dj.service

import home.dj.domain.AggregatedCosts
import home.dj.domain.Agreement
import home.dj.domain.AllocatedCost
import home.dj.domain.UtilityInvoice
import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context
import mu.KotlinLogging
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Context
class CostService(
    private val dbService: DatabaseService
) {

    private val logger = KotlinLogging.logger {}

    fun allocateCosts(utilityInvoice: UtilityInvoice, agreement: Agreement): List<AllocatedCost> {
        val dailyCost = utilityInvoice.amount.div(
            ChronoUnit.DAYS.between(
                utilityInvoice.startDate,
                utilityInvoice.endDate.plusDays(1)
            )
        )

        var dayCount = 1
        var startDate = utilityInvoice.startDate
        val allocatedCosts = mutableListOf<AllocatedCost>()
        utilityInvoice.startDate.plusDays(1).datesUntil(utilityInvoice.endDate.plusDays(1)).forEach {
            dayCount++
            if (it.plusDays(1).dayOfMonth == agreement.milestoneDay || it == utilityInvoice.endDate) {
                allocatedCosts.add(
                    AllocatedCost(
                        amount = dayCount * dailyCost,
                        startDate = startDate,
                        endDate = it,
                        agreementId = agreement.id,
                        costCategory = utilityInvoice.costCategory
                    )
                )
                dayCount = 0
                startDate = it.plusDays(1)
            }
        }
        return allocatedCosts.toList()
    }

    suspend fun getCostsForPeriod(startDate: LocalDate, endDate: LocalDate, agreement: Agreement): AggregatedCosts? {
        val dailyCosts = dbService.getCostsForPeriod(startDate, endDate, agreement.id)

        logger.info { dailyCosts }
        TODO("aggregation logic")
    }
}
