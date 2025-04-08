package com.bucketlisters.backend.challenge.integration.request

import java.time.LocalDate

data class ExternalEventFilter(
    val timeZone: String,
    val minDate: LocalDate? = null,
    val maxDate: LocalDate? = null,
    val page: Int? = null,
    val pageSize: Int? = null,
)
