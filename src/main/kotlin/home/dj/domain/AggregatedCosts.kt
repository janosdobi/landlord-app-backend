package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate

@Serdeable
data class AggregatedCosts(
    val costs: Map<CostCategory, Double>,
    @field:JsonProperty("start_date")
    val startDate: LocalDate,
    @field:JsonProperty("end_date")
    val endDate: LocalDate,
    @field:JsonProperty("invoice_files")
    val invoiceFiles: Set<InvoiceDocument>
)
