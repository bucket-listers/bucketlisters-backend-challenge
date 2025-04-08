package com.bucketlisters.backend.challenge.integration.response

import com.bucketlisters.backend.challenge.event.resource.response.EventsPageResponse

data class ExternalEventsPageResponse(
    val content: List<ExternalEventResponse> = listOf(),
    val totalPages: Int = 0,
    val totalElements: Int = 0,
) {

    fun toResponse(): EventsPageResponse {
        return EventsPageResponse(
            content = this.content.map { it.toResponse() },
            totalElements = this.totalElements,
            totalPages = this.totalPages,
        )
    }
}
