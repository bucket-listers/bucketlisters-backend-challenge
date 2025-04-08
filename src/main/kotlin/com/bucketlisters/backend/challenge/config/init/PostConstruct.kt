package com.bucketlisters.backend.challenge.config.init

import com.bucketlisters.backend.challenge.event.repository.EventEntity
import com.bucketlisters.backend.challenge.event.repository.EventRepository
import com.bucketlisters.backend.challenge.eventTicketType.repository.EventTicketTypeEntity
import com.bucketlisters.backend.challenge.eventTicketType.repository.EventTicketTypeRepository
import com.bucketlisters.backend.challenge.experience.repository.ExperienceEntity
import com.bucketlisters.backend.challenge.experience.repository.ExperienceRepository
import jakarta.annotation.PostConstruct
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import org.springframework.stereotype.Component

@Component
data class PostConstruct(
    private val experienceRepository: ExperienceRepository,
    private val eventTicketTypeRepository: EventTicketTypeRepository,
    private val eventRepository: EventRepository,
) {

    @PostConstruct
    fun populateH2() {
        val experience =
            experienceRepository.save(
                ExperienceEntity(name = "Bucket Listers Presents", timeZone = "America/Chicago")
            )

        this.buildEvents(experience)
    }

    private fun buildEvents(experience: ExperienceEntity) {
        val today = LocalDateTime.now().plusHours(1)
        var firstDate =
            ZonedDateTime.of(
                today.year,
                today.month.value,
                today.dayOfMonth,
                today.hour,
                0,
                0,
                0,
                ZoneId.of(experience.timeZone),
            )
        val lastDate = ZonedDateTime.now().plusDays(180)

        while (firstDate.isBefore(lastDate)) {

            val newEvent =
                eventRepository.save(
                    EventEntity(
                        name = "Bucket Listers Event",
                        experience = experience,
                        startTime = firstDate,
                        endTime = firstDate.plusMinutes(50),
                    )
                )

            eventTicketTypeRepository.saveAll(
                mutableListOf(
                    EventTicketTypeEntity(
                        name = "VIP",
                        description = "VIP ticket",
                        basePriceInCents = 3000,
                        event = newEvent,
                    ),
                    EventTicketTypeEntity(
                        name = "GA",
                        description = "GA ticket",
                        basePriceInCents = 1000,
                        event = newEvent,
                    ),
                )
            )

            firstDate = firstDate.plusDays(1)
        }
    }
}
