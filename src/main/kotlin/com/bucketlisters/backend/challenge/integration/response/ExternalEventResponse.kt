package com.bucketlisters.backend.challenge.integration.response

import com.bucketlisters.backend.challenge.event.resource.response.EventResponse
import java.time.ZonedDateTime

data class ExternalEventResponse(
    val eventId: String,
    val name: String,
    val startTime: ZonedDateTime,
    val endTime: ZonedDateTime,
) {

    fun toResponse(): EventResponse {
        return EventResponse(
            eventId = this.eventId,
            name = this.name,
            startTime = this.startTime,
            endTime = this.endTime,
        )
    }
}
