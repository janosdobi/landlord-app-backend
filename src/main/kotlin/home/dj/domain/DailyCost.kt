package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Min

@Serdeable
data class DailyCost(
    @field:Min(0)
    val id: Long? = null,
    @field:Min(0)
    val amount: Double,
    @field:Valid
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory,
    @field:JsonProperty("date")
    val date: LocalDate,
    val agreementId: Int
)
