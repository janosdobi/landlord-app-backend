package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min

@Serdeable
data class AllocatedCost(
    @field:Min(0)
    val id: Long = 0,
    @field:Min(0)
    val amount: Double,
    @field:Valid
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory,
    @field:JsonProperty("start_date")
    val startDate: LocalDate,
    @field:JsonProperty("end_date")
    val endDate: LocalDate,
    val agreementId: Long,
    var invoiceId: Long? = null
)
