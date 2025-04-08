package com.bucketlisters.backend.challenge.integration.response

import com.bucketlisters.backend.challenge.event.resource.response.EventTicketTypeResponse

data class ExternalEventTicketType(
    val eventTicketTypeId: String,
    val name: String,
    val description: String? = null,
    val basePriceInCents: Int,
) {

    fun toResponse(): EventTicketTypeResponse {
        return EventTicketTypeResponse(
            eventTicketTypeId = this.eventTicketTypeId,
            name = this.name,
            description = this.description,
            basePriceInCents = this.basePriceInCents,
        )
    }
}
