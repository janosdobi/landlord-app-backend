package home.dj

import io.micronaut.http.annotation.Controller
import mu.KotlinLogging
import org.jooq.DSLContext

@Controller
class MainController(
    private val context: DSLContext
) {
    private val logger = KotlinLogging.logger {}

}