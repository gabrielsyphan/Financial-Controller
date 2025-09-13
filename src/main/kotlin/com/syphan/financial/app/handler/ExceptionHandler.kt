package com.syphan.financial.app.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>> {
        val errors = ex.bindingResult.fieldErrors.associate { it.field to (it.defaultMessage ?: "Invalid value") }
        val body =
            mapOf(
                "status" to HttpStatus.BAD_REQUEST.value(),
                "error" to "Validation Error",
                "details" to errors,
            )
        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<Map<String, Any>> {
        val body =
            mapOf(
                "status" to HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "error" to "Internal Server Error",
                "message" to (ex.message ?: "Unexpected error"),
            )
        return ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
