package com.bucketlisters.backend.challenge.experience.service.impl

import com.bucketlisters.backend.challenge.config.error.exceptions.CustomNotFoundException
import com.bucketlisters.backend.challenge.experience.repository.ExperienceRepository
import com.bucketlisters.backend.challenge.experience.resource.response.ExperienceResponse
import com.bucketlisters.backend.challenge.experience.service.ExperienceService
import org.springframework.stereotype.Service

@Service
data class ExperienceServiceImpl(private val experienceRepository: ExperienceRepository) :
    ExperienceService {

    override fun findById(experienceId: Long): ExperienceResponse {
        return experienceRepository.findByExperienceId(experienceId)?.toResponse()
            ?: throw CustomNotFoundException(
                error = "Not found experience",
                details = mapOf("experienceId" to experienceId.toString()),
            )
    }

    override fun findAll(): List<ExperienceResponse> {
        return experienceRepository.findAll().map { experience -> experience.toResponse() }
    }
}
