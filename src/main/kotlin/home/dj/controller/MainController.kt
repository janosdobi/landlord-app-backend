package home.dj.controller

import home.dj.persistence.DatabaseService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import mu.KotlinLogging
import java.security.Principal

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
class MainController(
    private val databaseService: DatabaseService
) {
    private val logger = KotlinLogging.logger {}

    @Get("/test")
    suspend fun getMe(principal: Principal): HttpResponse<String> {
        return HttpResponse.ok("success")
    }
}
