package home.dj.domain

import io.micronaut.serde.annotation.Serdeable

@Serdeable
enum class UserRole {
    TENANT, LANDLORD, ADMIN
}
