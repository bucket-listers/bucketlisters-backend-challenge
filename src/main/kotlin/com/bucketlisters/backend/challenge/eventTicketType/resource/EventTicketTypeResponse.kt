package com.bucketlisters.backend.challenge.eventTicketType.resource

data class EventTicketTypeResponse(
    val eventTicketTypeId: String,
    val name: String,
    val description: String? = null,
    val basePriceInCents: Int,
)
