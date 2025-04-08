package com.bucketlisters.backend.challenge.event.service.impl

import com.bucketlisters.backend.challenge.event.repository.EventRepository
import com.bucketlisters.backend.challenge.event.resource.response.EventsPageResponse
import com.bucketlisters.backend.challenge.event.service.EventService
import com.bucketlisters.backend.challenge.eventTicketType.repository.EventTicketTypeRepository
import com.bucketlisters.backend.challenge.experience.service.ExperienceService
import com.bucketlisters.backend.challenge.integration.BlipFeignClient
import com.bucketlisters.backend.challenge.integration.request.ExternalEventFilter
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
data class EventServiceImpl(
    private val eventRepository: EventRepository,
    private val eventTicketTypeRepository: EventTicketTypeRepository,
    private val experienceService: ExperienceService,
    private val externalClient: BlipFeignClient,
) : EventService {

    @Transactional
    override fun findAllEvents(
        experienceId: Long,
        minDate: LocalDate,
        maxDate: LocalDate,
        page: Int,
        pageSize: Int,
    ): EventsPageResponse {
        val experience = experienceService.findById(experienceId = experienceId)
        val eventsPage =
            eventRepository.findAllByExperienceExperienceId(
                experienceId = experience.id,
                minDate = this.buildDateParam(minDate, experience.timeZone),
                maxDate = this.buildDateParam(maxDate, experience.timeZone),
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "startTime")),
            )
        return EventsPageResponse(
            content = eventsPage.content.map { event -> event.toResponse() },
            totalElements = eventsPage.totalElements.toInt(),
            totalPages = eventsPage.totalPages,
        )
    }

    private fun buildDateParam(dateToCovert: LocalDate, timeZone: String): ZonedDateTime {
        return ZonedDateTime.of(dateToCovert, LocalTime.now(), ZoneId.of(timeZone))
    }

    override fun findAllExternalEvents(
        experienceId: Long,
        minDate: LocalDate,
        maxDate: LocalDate,
        page: Int,
        pageSize: Int,
    ): EventsPageResponse {
        val experience = experienceService.findById(experienceId = experienceId)
        return externalClient
            .getEvents(
                experienceId = experience.id.toString(),
                ExternalEventFilter(
                    timeZone = experience.timeZone,
                    minDate = minDate,
                    maxDate = maxDate,
                    page = page,
                    pageSize = pageSize,
                ),
            )
            .toResponse()
    }
}
