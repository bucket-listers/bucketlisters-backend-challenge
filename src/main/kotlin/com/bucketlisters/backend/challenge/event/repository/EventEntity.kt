package com.bucketlisters.backend.challenge.event.repository

import com.bucketlisters.backend.challenge.event.resource.response.EventResponse
import com.bucketlisters.backend.challenge.eventTicketType.repository.EventTicketTypeEntity
import com.bucketlisters.backend.challenge.experience.repository.ExperienceEntity
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity(name = "event")
data class EventEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val eventId: Long = 0,
    val name: String,
    val startTime: ZonedDateTime,
    val endTime: ZonedDateTime,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "experience_id", nullable = false)
    val experience: ExperienceEntity,
    @OneToMany(mappedBy = "event")
    var eventTicketTypes: MutableList<EventTicketTypeEntity> = mutableListOf(),
) {

    fun toResponse(): EventResponse {
        return EventResponse(
            eventId = this.eventId.toString(),
            name = this.name,
            startTime = this.startTime,
            endTime = this.endTime,
            eventTicketTypes = this.eventTicketTypes.map { it.toResponse() },
        )
    }
}
