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
                val (credential, userId) = dbService.getCredentialAndIdForUser(it.identity)
                if (hasher.calculateHash(authenticationRequest.secret) == credential) {
                    AuthenticationResponse.success(
                        it.identity,
                        dbService.getUserRoles(userId).map { role -> role.name },
                        mapOf("uid" to userId)
                    )
                } else {
                    throw AuthenticationResponse.exception()
                }
            } ?: throw AuthenticationResponse.exception()
        }
}
