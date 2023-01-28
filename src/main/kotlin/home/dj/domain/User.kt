package home.dj.domain

import io.micronaut.serde.annotation.Serdeable
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Serdeable
data class User(
    @field:Min(0)
    val id: Long,
    @field:Size(min = 1)
    val name: String,
    val type: UserType,
    val agreement: Agreement
)

@Serdeable
enum class UserType {
    TENANT, LANDLORD
}
