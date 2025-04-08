package com.bucketlisters.backend.challenge.experience.resource

import com.bucketlisters.backend.challenge.experience.resource.response.ExperienceResponse
import com.bucketlisters.backend.challenge.experience.service.ExperienceService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Experience")
@RestController
@RequestMapping("/experiences")
data class ExperienceResource(private val experienceService: ExperienceService) {

    @Operation(summary = "This endpoint is used to retrieve the experiences from our sources")
    @GetMapping
    fun experiences(): List<ExperienceResponse> {
        return experienceService.findAll()
    }
}
