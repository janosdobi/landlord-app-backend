package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Introspected
data class Agreement(
    @field:NotNull
    @field:JsonProperty("uid")
    val uid: UUID,

    @field:NotNull
    @field:JsonProperty("start_date")
    val startDate: LocalDate,

    @field:JsonProperty("end_date")
    val endDate: LocalDate? = null,

    @field:NotNull
    @field:JsonProperty("tenant")
    val tenant: User,

    @field:NotNull
    @field:Valid
    @field:JsonProperty("landlord")
    val landlord: User,

    @field:NotNull
    @field:Valid
    @field:JsonProperty("rent")
    val rent: Rent,

    @field:NotNull
    @field:Valid
    @field:JsonProperty("utility_payment")
    val utilityPayment: UtilityPayment
)

@Introspected
data class Rent(
    @field:NotNull
    @field:Min(0)
    @field:JsonProperty("amount")
    val amount: Double,

    @field:NotNull
    @field:JsonProperty("currency")
    val currency: Currency
)

@Introspected
data class UtilityPayment(
    @field:NotNull
    @field:Min(0)
    @field:JsonProperty("amount")
    val amount: Double,

    @field:NotNull
    @field:JsonProperty("currency")
    val currency: Currency,

    @field:Valid
    @field:NotNull
    @field:JsonProperty("period")
    val period: Period
)

@Introspected
data class Period(
    @field:NotNull
    @field:Min(1)
    @field:Max(31)
    @field:JsonProperty("start")
    val start: Int = 1,

    @field:NotNull
    @field:Min(1)
    @field:Max(31)
    @field:JsonProperty("end")
    val end: Int = 31
)
