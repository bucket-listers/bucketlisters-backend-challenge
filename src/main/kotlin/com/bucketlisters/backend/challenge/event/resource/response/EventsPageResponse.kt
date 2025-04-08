package com.bucketlisters.backend.challenge.event.resource.response

data class EventsPageResponse(
    val content: List<EventResponse> = listOf(),
    val totalPages: Int = 0,
    val totalElements: Int = 0,
)
