package home.dj.service

import home.dj.domain.*
import home.dj.domain.response.CostsResponse
import home.dj.persistence.DatabaseService
import jakarta.inject.Singleton
import mu.KotlinLogging
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Singleton
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

    suspend fun getCostsForPeriod(
        startDate: LocalDate,
        endDate: LocalDate,
        agreement: Agreement
    ): CostsResponse {
        val milestoneDay = agreement.milestoneDay
        val aggregatedStart =
            if (startDate.dayOfMonth >= milestoneDay) startDate.withDayOfMonth(milestoneDay)
            else startDate.withDayOfMonth(milestoneDay).minusMonths(1)
        val aggregatedEnd =
            (if (endDate.dayOfMonth <= milestoneDay) endDate.withDayOfMonth(milestoneDay)
            else endDate.withDayOfMonth(milestoneDay).plusMonths(1)).minusDays(1)

        val costs = dbService.getCostsForPeriod(aggregatedStart, aggregatedEnd, agreement.id)

        val aggregatedCosts = mutableListOf<AggregatedCosts>()

        var firstDay = aggregatedStart
        var lastDay = aggregatedStart.plusMonths(1).minusDays(1)

        while ((lastDay.isBefore(aggregatedEnd) || lastDay.isEqual(aggregatedEnd))
            && costs.isNotEmpty() && costs.last().endDate.isAfter(firstDay)
        ) {
            val costsForPeriod = costs.filter {
                (it.startDate.isAfter(firstDay) || it.startDate.isEqual(firstDay))
                        && (it.endDate.isBefore(lastDay)) || it.endDate.isEqual(lastDay)
            }
            if (costsForPeriod.isNotEmpty()) {
                aggregatedCosts.add(
                    AggregatedCosts(
                        startDate = firstDay,
                        endDate = lastDay,
                        costs = costsForPeriod.groupBy({ it.costCategory }, { it.amount }).mapValues { it.value.sum() },
                        invoiceFiles = costsForPeriod.map { InvoiceDocument(it.invoiceId.toString(), ByteArray(0)) }
                            .toSet()
                    )
                )
            }
            firstDay = firstDay.plusMonths(1)
            lastDay = firstDay.plusMonths(1).minusDays(1)
        }

        return CostsResponse(
            agreement,
            aggregatedCosts.toList()
        )
    }
}
