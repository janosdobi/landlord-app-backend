package home.dj.controller

import home.dj.domain.UtilityInvoice
import home.dj.service.InvoiceService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import jakarta.annotation.security.RolesAllowed
import java.security.Principal
import javax.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
class LandlordController(
    private val invoiceService: InvoiceService
) {

    @Post("/{agreementId}/invoice")
    @RolesAllowed("LANDLORD")
    suspend fun submitInvoice(
        @PathVariable agreementId: Int,
        @Valid @Body utilityInvoice: UtilityInvoice,
        principal: Principal
    ): HttpResponse<Unit> {
        invoiceService.handleInvoice(utilityInvoice)
        return HttpResponse.ok()
    }
}