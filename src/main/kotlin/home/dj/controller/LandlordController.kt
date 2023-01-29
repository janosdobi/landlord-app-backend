package home.dj.controller

import home.dj.domain.UtilityInvoiceDTO
import home.dj.service.AgreementService
import home.dj.service.InvoiceService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.ServerAuthentication
import io.micronaut.security.rules.SecurityRule
import jakarta.annotation.security.RolesAllowed
import java.security.Principal
import javax.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
class LandlordController(
    private val invoiceService: InvoiceService,
    private val agreementService: AgreementService
) {

    @Post("/invoice", consumes = [MediaType.MULTIPART_FORM_DATA])
    @RolesAllowed(*["LANDLORD"])
    suspend fun submitInvoice(
        @Valid @Body invoice: UtilityInvoiceDTO,
        fileContent: ByteArray,
        principal: Principal
    ): HttpResponse<Unit> {
        val uid = ((principal as ServerAuthentication).attributes["uid"] as Long).toInt()
        val agreement = agreementService.getAgreementForLandlord(invoice.agreementId, uid)
        invoiceService.handleInvoice(invoice.fromDTO(fileContent), agreement, principal.name)
        return HttpResponse.ok()
    }
}