package home.dj.domain.response

import com.fasterxml.jackson.annotation.JsonProperty
import home.dj.domain.AggregatedCosts
import home.dj.domain.Agreement
import io.micronaut.serde.annotation.Serdeable
import javax.validation.Valid

@Serdeable
data class CostsResponse(
    @field:Valid
    val agreement: Agreement,
    @field:Valid
    @field:JsonProperty("aggregated_costs")
    val aggregatedCosts: List<AggregatedCosts>
)
