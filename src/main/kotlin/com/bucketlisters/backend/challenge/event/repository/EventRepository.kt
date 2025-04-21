package com.bucketlisters.backend.challenge.event.repository

import java.time.ZonedDateTime
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface EventRepository :
    CrudRepository<EventEntity, Long>, PagingAndSortingRepository<EventEntity, Long> {

    @Query(
        "SELECT e FROM event e WHERE e.experience.experienceId = :experienceId AND e.startTime BETWEEN :minDate AND :maxDate"
    )
    fun findAllByExperienceExperienceId(
        @Param("experienceId") experienceId: Long,
        @Param("minDate") minDate: ZonedDateTime,
        @Param("maxDate") maxDate: ZonedDateTime,
        pageable: Pageable,
    ): Page<EventEntity>
}
