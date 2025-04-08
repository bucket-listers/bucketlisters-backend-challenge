package com.bucketlisters.backend.challenge.event.resource.response

data class EventTicketTypeResponse(
    val eventTicketTypeId: String,
    val name: String,
    val description: String? = null,
    val basePriceInCents: Int,
)
