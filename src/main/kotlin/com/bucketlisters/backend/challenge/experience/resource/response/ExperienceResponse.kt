package com.bucketlisters.backend.challenge.experience.resource.response

import com.bucketlisters.backend.challenge.experience.util.TicketingSystemEnum

data class ExperienceResponse(
    val id: Long,
    val name: String,
    val timeZone: String,
    val ticketingSystem: TicketingSystemEnum = TicketingSystemEnum.BUCKET_LISTERS,
)
