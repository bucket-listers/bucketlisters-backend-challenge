package com.bucketlisters.backend.challenge.experience.service

import com.bucketlisters.backend.challenge.experience.resource.response.ExperienceResponse

interface ExperienceService {

    fun findById(experienceId: Long): ExperienceResponse

    fun findAll(): List<ExperienceResponse>
}
