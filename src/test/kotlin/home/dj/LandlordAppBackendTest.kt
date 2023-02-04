package home.dj

import home.dj.persistence.DatabaseService
import io.kotest.core.spec.style.StringSpec
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.mockk

@MicronautTest
class LandlordAppBackendTest(private val application: EmbeddedApplication<*>) : StringSpec({

    "test the server is running" {
        assert(application.isRunning)
    }
}) {
    @MockBean(DatabaseService::class)
    fun databaseService() = mockk<DatabaseService>()
}
