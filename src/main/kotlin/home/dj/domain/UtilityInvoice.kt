package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import home.dj.domain.request.InvoiceRequest
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min

@Serdeable
data class UtilityInvoice(
    @field:Min(0)
    val id: Long = 0,
    @field:Min(0)
    val amount: Double,
    @field:JsonProperty("start_date")
    val startDate: LocalDate,
    @field:JsonProperty("end_date")
    val endDate: LocalDate,
    @field:Valid
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory,
    @field:JsonProperty("invoice_document")
    @field:Valid
    val invoiceDocument: InvoiceDocument,
    @field:JsonProperty("agreement_id")
    val agreementId: Long
) {
    companion object {
        fun fromRequest(request: InvoiceRequest, fileContent: ByteArray) = UtilityInvoice(
            amount = request.amount,
            startDate = request.startDate,
            endDate = request.endDate,
            costCategory = request.costCategory,
            invoiceDocument = InvoiceDocument(request.fileName, fileContent),
            agreementId = request.agreementId
        )
    }
}
