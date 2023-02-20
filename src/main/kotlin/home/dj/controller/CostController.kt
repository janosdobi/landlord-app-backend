package home.dj.controller

import home.dj.domain.UserRole
import home.dj.domain.UserRole.LANDLORD
import home.dj.domain.UserRole.TENANT
import home.dj.domain.response.CostsResponse
import home.dj.service.AgreementService
import home.dj.service.CostService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import jakarta.annotation.security.RolesAllowed
import java.time.LocalDate

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
class CostController(
    private val agreementService: AgreementService,
    private val costService: CostService
) {

    @Get("/{agreementId}/cost")
    @RolesAllowed(*["LANDLORD", "TENANT"])
    suspend fun getCostsForPeriod(
        @PathVariable agreementId: Long,
        @QueryValue("s") startDateString: String,
        @QueryValue("e") endDateString: String,
        auth: Authentication
    ): HttpResponse<CostsResponse> {
        val uid = (auth.attributes["uid"] as Long).toInt()
        val role = auth.roles.map { UserRole.valueOf(it) }.first { it == LANDLORD || it == TENANT }
        val agreement = agreementService.getAgreementForUser(agreementId, uid, role)
        return HttpResponse.ok(
            costService.getCostsForPeriod(
                LocalDate.parse(startDateString),
                LocalDate.parse(endDateString),
                agreement
            )
        )
    }
}