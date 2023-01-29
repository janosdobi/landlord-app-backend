package home.dj.service

import home.dj.persistence.DatabaseService
import io.micronaut.context.annotation.Context

@Context
class AgreementService(
    private val dbService: DatabaseService
) {

    suspend fun getAgreementForLandlord(agreementId: Int, uid: Int) =
        dbService.fetchAgreementForLandlord(agreementId, uid)
}