package home.dj.error

import io.micronaut.context.annotation.Primary
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton

@Singleton
@Primary
class LandlordErrorResponseProcessor : ErrorResponseProcessor<String> {

    override fun processResponse(
        errorContext: ErrorContext,
        baseResponse: MutableHttpResponse<*>
    ): MutableHttpResponse<String> {
        val error = if (!errorContext.hasErrors()) {
            baseResponse.status.reason
        } else if (errorContext.errors.size == 1) {
            errorContext.errors[0].message
        } else {
            "Reason: ${baseResponse.status.reason}, errors: ${errorContext.errors.map { it.message }}"
        }
        return baseResponse.body(error)
    }
}