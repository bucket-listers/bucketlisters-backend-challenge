package com.bucketlisters.backend.challenge.config.gson

import com.bucketlisters.backend.challenge.config.gson.adapter.InstantTypeAdapter
import com.bucketlisters.backend.challenge.config.gson.adapter.LocalDateTypeAdapter
import com.bucketlisters.backend.challenge.config.gson.adapter.LocalTimeTypeAdapter
import com.bucketlisters.backend.challenge.config.gson.adapter.ZoneDateTimeTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import java.time.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GsonConfig {

    @Bean
    fun customGson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalTime::class.java, LocalTimeTypeAdapter())
            .registerTypeAdapter(ZonedDateTime::class.java, ZoneDateTimeTypeAdapter())
            .registerTypeAdapter(LocalDate::class.java, LocalDateTypeAdapter())
            .registerTypeAdapter(Instant::class.java, InstantTypeAdapter())
            .create()
    }

    @Bean
    fun customGsonEncoder(): GsonEncoder {
        return GsonEncoder(customGson())
    }

    @Bean
    fun customGsonDecoder(): GsonDecoder {
        return GsonDecoder(customGson())
    }
}
