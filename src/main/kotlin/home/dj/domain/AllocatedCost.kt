package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import java.time.Month
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Introspected
data class AllocatedCost(
    @field:NotNull
    @field:JsonProperty("uid")
    val uid: UUID,

    @field:NotNull
    @field:Min(0)
    @field:JsonProperty("amount")
    val amount: Double,

    @field:Valid
    @field:NotNull
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory,

    @field:NotNull
    @field:JsonProperty("month")
    val month: Month
)
