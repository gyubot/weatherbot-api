package weatherbot.configuration

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*
import java.util.concurrent.TimeoutException
import javax.validation.ConstraintViolationException

@ControllerAdvice(basePackages = ["weatherbot"])
@ResponseBody
class AdviceController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        ConstraintViolationException::class
    )
    fun handleException(e: ConstraintViolationException): Response? {
        return Response(
            message = e.message ?: "오류가 발생했습니다"
        )
    }

    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(
        TimeoutException::class
    )
    fun handleException(e: TimeoutException): Response? {
        return Response(
            message = "요청 시간이 초과되었습니다"
        )
    }
}

data class Response(
    val message: String
)
