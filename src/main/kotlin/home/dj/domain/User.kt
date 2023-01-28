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
    val roles: List<UserRole>,
    val agreement: Agreement
)

@Serdeable
enum class UserRole {
    TENANT, LANDLORD, ADMIN
}
