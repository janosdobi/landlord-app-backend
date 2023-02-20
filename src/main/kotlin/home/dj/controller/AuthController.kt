package home.dj.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/auth")
@Secured(SecurityRule.IS_AUTHENTICATED)
class AuthController {

    @Get("/valid")
    fun isTokenValid(): HttpResponse<Unit> {
        return HttpResponse.noContent()
    }
}