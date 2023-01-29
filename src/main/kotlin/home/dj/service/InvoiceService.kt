package home.dj.service

import home.dj.domain.Agreement
import home.dj.domain.UtilityInvoice
import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context

@Context
class InvoiceService(
    private val dbService: DatabaseService,
    private val costService: CostService
) {
    suspend fun handleInvoice(utilityInvoice: UtilityInvoice, agreement: Agreement, userName: String) {
        validateInvoice(utilityInvoice, agreement)
        val dailyCosts = costService.splitToDailyCosts(utilityInvoice, agreement)
        dbService.persistInvoiceWithCosts(utilityInvoice, dailyCosts, userName)
    }

    private fun validateInvoice(utilityInvoice: UtilityInvoice, agreement: Agreement) {
        if (utilityInvoice.startDate.isBefore(agreement.startDate) ||
            agreement.endDate?.let { utilityInvoice.endDate.isAfter(it) } == true
        ) throw IllegalArgumentException("Invoice date range is out of agreement date range")

        if (utilityInvoice.endDate.isBefore(utilityInvoice.startDate))
            throw IllegalArgumentException("Invoice end date is before invoice start date")
    }
}
