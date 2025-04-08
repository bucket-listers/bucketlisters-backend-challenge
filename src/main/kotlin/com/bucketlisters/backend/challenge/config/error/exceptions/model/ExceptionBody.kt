package com.bucketlisters.backend.challenge.config.error.exceptions.model

import java.io.Serializable

data class ExceptionBody(
    val code: Int? = null,
    val message: String? = null,
    val data: Map<String, String> = mapOf(),
) : Serializable
