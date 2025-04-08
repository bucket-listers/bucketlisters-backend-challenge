package com.bucketlisters.backend.challenge.event.resource.response

import java.time.ZonedDateTime

data class EventResponse(
    val eventId: String,
    val name: String,
    val startTime: ZonedDateTime,
    val endTime: ZonedDateTime,
    val eventTicketTypes: List<EventTicketTypeResponse> = listOf(),
)
