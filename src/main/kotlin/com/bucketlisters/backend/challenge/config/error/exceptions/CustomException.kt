package com.bucketlisters.backend.challenge.config.error.exceptions

open class CustomException(
    open val code: Int? = null,
    open val error: String? = null,
    open val details: Map<String, String> = mapOf(),
) : RuntimeException()
