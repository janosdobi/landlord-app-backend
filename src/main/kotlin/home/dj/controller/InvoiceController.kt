package home.dj.controller

import home.dj.domain.UserRole
import home.dj.domain.UtilityInvoice
import home.dj.domain.request.InvoiceRequest
import home.dj.service.AgreementService
import home.dj.service.InvoiceService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import jakarta.annotation.security.RolesAllowed
import javax.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
class InvoiceController(
    private val invoiceService: InvoiceService,
    private val agreementService: AgreementService
) {

    @Post("/invoice", consumes = [MediaType.MULTIPART_FORM_DATA])
    @RolesAllowed(*["LANDLORD"])
    suspend fun submitInvoice(
        @Valid @Body invoice: InvoiceRequest,
        fileContent: ByteArray,
        auth: Authentication
    ): HttpResponse<Unit> {
        val uid = (auth.attributes["uid"] as Long).toInt()
        val agreement = agreementService.getAgreementForUser(invoice.agreementId, uid, UserRole.LANDLORD)
        invoiceService.handleInvoice(UtilityInvoice.fromRequest(invoice, fileContent), agreement, auth.name)
        return HttpResponse.accepted()
    }
}