package home.dj

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "landlord-app-backend",
        version = "0.0"
    )
)
object Api {
}

fun main(args: Array<String>) {
    Micronaut.build()
        .args(*args)
        .banner(false)
        .environments("local")
        .start()
}

