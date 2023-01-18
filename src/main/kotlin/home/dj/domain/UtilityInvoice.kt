package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class UtilityInvoice(
    @field:NotNull
    @field:Size(min = 1)
    @field:JsonProperty("id")
    val id: String,

    @field:NotNull
    @field:Min(0)
    @field:JsonProperty("amount")
    val amount: Double,

    @field:NotNull
    @field:JsonProperty("start_date")
    val startDate: LocalDate,

    @field:NotNull
    @field:JsonProperty("end_date")
    val endDate: LocalDate,

    @field:Valid
    @field:NotNull
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory
)
