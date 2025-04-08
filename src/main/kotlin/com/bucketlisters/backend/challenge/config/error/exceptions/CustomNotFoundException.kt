package com.bucketlisters.backend.challenge.config.error.exceptions

import org.springframework.http.HttpStatus

data class CustomNotFoundException(
    override val code: Int = HttpStatus.NOT_FOUND.value(),
    override val error: String? = null,
    override val details: Map<String, String> = mapOf(),
) : CustomException()
