package com.bucketlisters.backend.challenge.config.error.exceptions.model

import java.io.Serializable

data class WrappedBlipException(val error: ExceptionBody? = null) : Serializable
