package com.bucketlisters.backend.challenge.event.resource

import com.bucketlisters.backend.challenge.event.resource.response.EventsPageResponse
import com.bucketlisters.backend.challenge.event.service.EventService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import java.time.LocalDate
import org.springframework.web.bind.annotation.*

@Tag(name = "Event")
@RestController
@RequestMapping("/events")
data class EventResource(private val eventService: EventService) {

    @Operation(
        summary = "This endpoint is used to retrieve the external events from our experiences"
    )
    @GetMapping("/external/{experienceId}")
    fun externalEventsPage(
        @PathVariable("experienceId") experienceId: Long,
        @RequestParam("minDate", required = false) minDate: LocalDate = LocalDate.now(),
        @RequestParam("maxDate", required = false) maxDate: LocalDate = minDate.plusDays(90),
        @RequestParam("page", defaultValue = "0") page: Int,
        @RequestParam("pageSize", defaultValue = "10") pageSize: Int,
    ): EventsPageResponse {
        return eventService.findAllExternalEvents(experienceId, minDate, maxDate, page, pageSize)
    }

    @Operation(
        summary = "This endpoint is used to retrieve the internal events from our experiences"
    )
    @GetMapping("/{experienceId}")
    fun eventsPage(
        @PathVariable("experienceId") experienceId: Long,
        @RequestParam("minDate", required = false) minDate: LocalDate = LocalDate.now(),
        @RequestParam("maxDate", required = false) maxDate: LocalDate = minDate.plusDays(90),
        @RequestParam("page", defaultValue = "0") page: Int,
        @RequestParam("pageSize", defaultValue = "10") pageSize: Int,
    ): EventsPageResponse {
        return eventService.findAllEvents(experienceId, minDate, maxDate, page, pageSize)
    }
}
