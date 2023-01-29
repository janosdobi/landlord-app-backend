package home.dj.service

import home.dj.domain.UserRole
import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context

@Context
class AgreementService(
    private val dbService: DatabaseService
) {

    suspend fun getAgreementForUser(agreementId: Int, uid: Int, role: UserRole) =
        dbService.fetchAgreementForUser(agreementId, uid, role)
}