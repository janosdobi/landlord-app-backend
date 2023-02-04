package home.dj.error

import com.fasterxml.jackson.core.JsonProcessingException
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.convert.exceptions.ConversionErrorException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.security.authentication.AuthenticationException
import io.micronaut.security.authentication.AuthorizationException
import io.micronaut.security.errors.ErrorResponse
import io.micronaut.web.router.exceptions.UnsatisfiedRouteException
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.ErrorDataDecoderException
import mu.KotlinLogging
import javax.persistence.NoResultException
import javax.validation.ConstraintViolationException

private const val INTERNAL_ERROR_MESSAGE = "Something went wrong."
private const val INVALID_REQUEST = "Invalid request"
private const val INVALID_PROPERTY = "Invalid property"

@Controller
@Introspected(
    classes = [String::class]
)
class ErrorController {
    private val logger = KotlinLogging.logger {}

    @Error(AuthorizationException::class, global = true)
    fun authorizationExceptionHandler(request: HttpRequest<*>, ex: AuthorizationException): HttpResponse<Void> {
        logger.warn { "Unauthorized request. ${ex.message ?: ""}" }
        return HttpResponse.unauthorized()
    }

    @Error(AuthenticationException::class, global = true)
    fun authenticationExceptionHandler(request: HttpRequest<*>, ex: AuthenticationException): HttpResponse<Void> {
        logger.warn { "Authentication failed. ${ex.message ?: ""}" }
        return HttpResponse.status(HttpStatus.FORBIDDEN)
    }

    @Error(NoResultException::class, global = true)
    fun noResultExceptionHandler(request: HttpRequest<*>, ex: NoResultException): HttpResponse<String> {
        logger.warn { "No result found for request ${ex.message}" }
        return HttpResponse.badRequest<String>()
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.message)
    }

    @Error(IllegalArgumentException::class, global = true)
    fun illegalArgumentExceptionHandler(request: HttpRequest<*>, ex: IllegalArgumentException): HttpResponse<String> {
        logger.warn { "Illegal argument for request ${ex.message}" }
        return HttpResponse.badRequest<String>()
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.message)
    }

    @Error(ErrorDataDecoderException::class, global = true)
    fun dataDecoderExceptionHandler(request: HttpRequest<*>, ex: ErrorDataDecoderException): HttpResponse<String> {
        logger.warn { "Failed to decode request data ${ex.message}" }
        return HttpResponse.badRequest<String>()
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.message)
    }

    @Error(global = true)
    fun onValidationError(ex: ConstraintViolationException): HttpResponse<String> {
        val errors = ex.constraintViolations.stream()
            .map { violation -> violation.propertyPath.last().toString() + ": " + violation.message }
            .toList().joinToString("\n")

        val errorMessage = "$INVALID_PROPERTY $errors"

        logger.warn { errorMessage }

        return HttpResponse.badRequest<String>()
            .status(HttpStatus.BAD_REQUEST)
            .body(errorMessage)
    }

    @Error(global = true)
    fun onJSONException(ex: JsonProcessingException): HttpResponse<String> {
        val errorMessage = "$INVALID_REQUEST: request JSON cannot be processed."

        logger.warn { "$errorMessage. Reason: ${ex.message}" }

        return HttpResponse.badRequest<String>()
            .status(HttpStatus.BAD_REQUEST)
            .body(errorMessage)
    }

    @Error(global = true)
    fun onRoutingException(ex: UnsatisfiedRouteException): HttpResponse<String> {
        val errorMessage = "$INVALID_REQUEST: ${ex.message}"

        return HttpResponse.badRequest<String>()
            .status(HttpStatus.BAD_REQUEST)
            .body(errorMessage)
    }

    @Error(global = true)
    fun onConversionError(ex: ConversionErrorException): HttpResponse<String> {
        val error = ex.conversionError.cause.message ?: ex.message

        val exceptionMessage = "$INVALID_REQUEST${if (error != null) ": $error" else ""}"
        val errorMessage =
            "$INVALID_REQUEST: type and property [${ex.argument}] is not in line with the API specification"

        logger.warn { exceptionMessage }

        return HttpResponse.badRequest<ErrorResponse>()
            .status(HttpStatus.BAD_REQUEST)
            .body(errorMessage)
    }

    @Error(global = true)
    fun onGeneralError(ex: Throwable): HttpResponse<String> {

        logger.error(ex) { ex.message }

        return HttpResponse.serverError<ErrorResponse>()
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(INTERNAL_ERROR_MESSAGE)
    }
}
