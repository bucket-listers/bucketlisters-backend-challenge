package com.bucketlisters.backend.challenge.eventTicketType.repository

import com.bucketlisters.backend.challenge.event.repository.EventEntity
import com.bucketlisters.backend.challenge.event.resource.response.EventTicketTypeResponse
import jakarta.persistence.*

@Entity(name = "event_ticket_type")
class EventTicketTypeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val eventTicketTypeId: Long = 0,
    val name: String,
    val description: String? = null,
    val basePriceInCents: Int,
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    val event: EventEntity,
) {

    fun toResponse(): EventTicketTypeResponse {
        return EventTicketTypeResponse(
            eventTicketTypeId = this.eventTicketTypeId.toString(),
            name = this.name,
            description = this.description,
            basePriceInCents = this.basePriceInCents,
        )
    }
}
