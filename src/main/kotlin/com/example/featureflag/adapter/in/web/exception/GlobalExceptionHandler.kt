package com.example.featureflag.adapter.`in`.web.exception

import com.example.featureflag.adapter.`in`.web.dto.ExceptionResponseDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.RuntimeException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException::class)
    fun exceptionHandler(): ExceptionResponseDto = ExceptionResponseDto.of(
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
        message = "현재 해당 API는 사용할 수 없습니다."
    )
}
