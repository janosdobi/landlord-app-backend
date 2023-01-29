package home.dj.service

import home.dj.domain.Agreement
import home.dj.domain.DailyCost
import home.dj.domain.UtilityInvoice
import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context
import java.time.temporal.ChronoUnit
import kotlin.streams.asSequence

@Context
class InvoiceService(
    private val dbService: DatabaseService
) {
    suspend fun handleInvoice(utilityInvoice: UtilityInvoice, agreement: Agreement, userName: String) {
        validateInvoice(utilityInvoice, agreement)
        val dailyCosts = splitToDailyCosts(utilityInvoice, agreement)
        dbService.persistInvoiceWithCosts(utilityInvoice, dailyCosts, userName)
    }

    private fun validateInvoice(utilityInvoice: UtilityInvoice, agreement: Agreement) {
        if (utilityInvoice.startDate.isBefore(agreement.startDate) ||
            agreement.endDate?.let { utilityInvoice.endDate.isAfter(it) } == true
        ) throw IllegalArgumentException("Invoice date range is out of agreement date range")

        if (utilityInvoice.endDate.isBefore(utilityInvoice.startDate))
            throw IllegalArgumentException("Invoice end date is before invoice start date")
    }

    private fun splitToDailyCosts(utilityInvoice: UtilityInvoice, agreement: Agreement): Sequence<DailyCost> {
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
                agreement = agreement
            )
        }.asSequence()
    }
}
