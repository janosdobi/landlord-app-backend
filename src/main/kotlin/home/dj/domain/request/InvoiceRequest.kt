package home.dj.domain.request

import com.fasterxml.jackson.annotation.JsonProperty
import home.dj.domain.CostCategory
import home.dj.domain.UtilityInvoice
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min

@Serdeable
data class InvoiceRequest(
    @field:Min(0)
    val amount: Double,
    @field:JsonProperty("start_date")
    val startDate: LocalDate,
    @field:JsonProperty("end_date")
    val endDate: LocalDate,
    @field:Valid
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory,
    @field:JsonProperty("file_name")
    val fileName: String,
    @field:JsonProperty("agreement_id")
    val agreementId: Int
)