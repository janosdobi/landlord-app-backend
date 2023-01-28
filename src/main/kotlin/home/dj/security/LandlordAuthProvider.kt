package home.dj.security

import home.dj.persistence.DatabaseService
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UsernamePasswordCredentials
import jakarta.inject.Singleton
import kotlinx.coroutines.reactor.mono
import org.reactivestreams.Publisher

@Singleton
class LandlordAuthProvider(
    private val hasher: LandlordHasher,
    private val dbService: DatabaseService
) : AuthenticationProvider {

    override fun authenticate(
        @Nullable httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> =
        mono {
            (authenticationRequest as? UsernamePasswordCredentials)?.let {
                if (hasher.calculateHash(authenticationRequest.secret) == dbService.getCredentialForUser(it.identity)) {
                    AuthenticationResponse.success(
                        it.identity,
                        dbService.getUserRoles(it.identity).map { role -> role.name }
                    )
                } else {
                    throw AuthenticationResponse.exception()
                }
            } ?: throw AuthenticationResponse.exception()
        }
}
