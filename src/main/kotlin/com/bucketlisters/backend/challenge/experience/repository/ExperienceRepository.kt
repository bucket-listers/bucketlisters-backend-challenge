package com.bucketlisters.backend.challenge.experience.repository

import org.springframework.data.repository.CrudRepository

interface ExperienceRepository : CrudRepository<ExperienceEntity, Long> {

    fun findByExperienceId(experienceId: Long): ExperienceEntity?
}
