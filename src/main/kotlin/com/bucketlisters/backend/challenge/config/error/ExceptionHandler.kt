package com.bucketlisters.backend.challenge.config.error

import com.bucketlisters.backend.challenge.config.error.exceptions.CustomException
import com.bucketlisters.backend.challenge.config.error.exceptions.CustomNotFoundException
import com.bucketlisters.backend.challenge.config.error.exceptions.model.ExceptionBody
import com.bucketlisters.backend.challenge.config.error.exceptions.model.WrappedBlipException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(CustomNotFoundException::class)
    fun handleBlipException(ex: CustomException): ResponseEntity<WrappedBlipException> {

        val errorMessage =
            WrappedBlipException(
                error = ExceptionBody(code = ex.code, message = ex.error, data = ex.details)
            )
        return ResponseEntity(errorMessage, HttpStatus.valueOf(ex.code!!))
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleBlipException(
        ex: HttpMessageNotReadableException
    ): ResponseEntity<WrappedBlipException> {

        val errorMessage =
            WrappedBlipException(
                error = ExceptionBody(code = HttpStatus.BAD_REQUEST.value(), message = ex.message)
            )
        return ResponseEntity(errorMessage, HttpStatus.valueOf(errorMessage.error!!.code!!))
    }
}
