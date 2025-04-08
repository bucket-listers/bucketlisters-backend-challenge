package com.bucketlisters.backend.challenge.experience.repository

import com.bucketlisters.backend.challenge.experience.resource.response.ExperienceResponse
import com.bucketlisters.backend.challenge.experience.util.TicketingSystemEnum
import jakarta.persistence.*

@Entity(name = "experience")
data class ExperienceEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val experienceId: Long = 0,
    val name: String,
    val timeZone: String,
    @Enumerated(EnumType.STRING)
    val ticketingSystem: TicketingSystemEnum = TicketingSystemEnum.BUCKET_LISTERS,
) {

    fun toResponse(): ExperienceResponse {
        return ExperienceResponse(
            id = this.experienceId,
            name = this.name,
            timeZone = this.timeZone,
            ticketingSystem = this.ticketingSystem,
        )
    }
}
