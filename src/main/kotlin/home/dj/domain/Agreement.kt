package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Serdeable
data class Agreement(
    @field:Min(0)
    val id: Long,
    @field:JsonProperty("start_date")
    val startDate: LocalDate,
    @field:JsonProperty("end_date")
    val endDate: LocalDate? = null,
    @field:Valid
    val tenantId: Int,
    @field:Valid
    val landlordId: Int,
    @field:Valid
    val rentAgreement: RentAgreement,
    @field:Valid
    @field:JsonProperty("utility_agreement")
    val utilityAgreement: UtilityAgreement,
    @field:Valid
    @field:Min(1)
    @field:Max(31)
    val milestoneDay: Int
)

@Serdeable
data class RentAgreement(
    @field:Min(0)
    val amount: Double,
    val currency: Currency
)

@Serdeable
data class UtilityAgreement(
    @field:Min(0)
    val amount: Double,
    val currency: Currency
)
