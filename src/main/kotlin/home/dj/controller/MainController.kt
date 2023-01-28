package home.dj.controller

import home.dj.persistence.DatabaseService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import mu.KotlinLogging

@Controller
class MainController(
    private val databaseService: DatabaseService
) {
    private val logger = KotlinLogging.logger {}


    @Get("/test")
    fun getMe() {
        logger.info { databaseService.getUserById(1) }
    }
}
