package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class User(

    @field:NotNull
    @field:JsonProperty("uid")
    val uid: UUID,

    @field:NotNull
    @field:Size(min = 1)
    @field:JsonProperty("name")
    val name: String,

    @field:NotNull
    @field:JsonProperty("type")
    val type: UserType,
)

@Introspected
enum class UserType {
    TENANT, LANDLORD
}
