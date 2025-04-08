package com.bucketlisters.backend.challenge.event.service

import com.bucketlisters.backend.challenge.event.resource.response.EventsPageResponse
import java.time.LocalDate

interface EventService {

    fun findAllEvents(
        experienceId: Long,
        minDate: LocalDate,
        maxDate: LocalDate,
        page: Int,
        pageSize: Int,
    ): EventsPageResponse

    fun findAllExternalEvents(
        experienceId: Long,
        minDate: LocalDate,
        maxDate: LocalDate,
        page: Int,
        pageSize: Int,
    ): EventsPageResponse
}
