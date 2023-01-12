package br.com.gabrielmusskopf.api.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
internal class RestErrorHandler : ResponseEntityExceptionHandler() {

		@ExceptionHandler(value = [Exception::class])
		fun handleGlobalException(exception: Exception, httpServletRequest: HttpServletRequest): ResponseEntity<Error> {
			return ResponseEntity.internalServerError()
					.body(Error("Um erro ocorreu.", HttpStatus.INTERNAL_SERVER_ERROR, httpServletRequest.servletPath))
		}

		@ExceptionHandler(value = [BusinessException::class])
		fun handleBusinessException(exception: BusinessException, httpServletRequest: HttpServletRequest): ResponseEntity<Error> {
			return ResponseEntity.badRequest()
					.body(Error(exception.message, HttpStatus.BAD_REQUEST, httpServletRequest.servletPath))
		}
}