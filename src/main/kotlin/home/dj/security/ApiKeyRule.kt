package home.dj.security

import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.AbstractSecurityRule
import io.micronaut.security.rules.SecuredAnnotationRule
import io.micronaut.security.rules.SecurityRuleResult
import io.micronaut.security.token.RolesFinder
import io.micronaut.web.router.RouteMatch
import jakarta.inject.Singleton
import kotlinx.coroutines.reactor.mono
import org.reactivestreams.Publisher

@Singleton
class ApiKeyRule(
    rolesFinder: RolesFinder,
    @Value("\${landlord.app.api.key}") private val apikey: String
) : AbstractSecurityRule(rolesFinder) {
    override fun check(
        request: HttpRequest<*>?,
        routeMatch: RouteMatch<*>?,
        authentication: Authentication?
    ): Publisher<SecurityRuleResult> {
        val keyFromRequest = request?.headers?.get("API-KEY") ?: ""
        return mono { if (apikey == keyFromRequest) SecurityRuleResult.UNKNOWN else SecurityRuleResult.REJECTED }
    }

    override fun getOrder() = SecuredAnnotationRule.ORDER - 100
}
