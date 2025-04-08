package com.bucketlisters.backend.challenge.integration

import com.bucketlisters.backend.challenge.integration.request.ExternalEventFilter
import com.bucketlisters.backend.challenge.integration.response.ExternalEventsPageResponse
import feign.Headers
import feign.Param
import feign.QueryMap
import feign.RequestLine

interface BlipFeignClient {

    @RequestLine("GET /experiences/{experienceId}/events")
    @Headers("Accept: application/json")
    fun getEvents(
        @Param("experienceId") experienceId: String,
        @QueryMap filter: ExternalEventFilter,
    ): ExternalEventsPageResponse
}
