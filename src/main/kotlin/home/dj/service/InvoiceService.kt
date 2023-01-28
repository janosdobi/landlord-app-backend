package home.dj.service

import home.dj.domain.AllocatedCost
import home.dj.domain.UtilityInvoice
import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context

@Context
class InvoiceService(
    private val databaseService: DatabaseService
) {
    fun handleInvoice(utilityInvoice: UtilityInvoice) {
        val allocatedCosts = allocateCosts(utilityInvoice)
    }

    private fun allocateCosts(utilityInvoice: UtilityInvoice): List<AllocatedCost> {
        TODO("Not yet implemented")
    }
}
