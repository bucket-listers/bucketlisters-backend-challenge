package com.bucketlisters.backend.challenge.integration.config

import com.bucketlisters.backend.challenge.integration.BlipFeignClient
import feign.Feign
import feign.Retryer
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.okhttp.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlipClientConfig(
    @Value("\${blip.api.url}") val apiUrl: String,
    val customFrontGateGsonEncoder: GsonEncoder,
    val customFrontGateGsonDecoder: GsonDecoder,
) {

    private fun clientBuilder(): Feign.Builder {
        return Feign.builder()
            .retryer(Retryer.Default())
            .client(OkHttpClient())
            .encoder(customFrontGateGsonEncoder)
            .decoder(customFrontGateGsonDecoder)
            .errorDecoder(BlipErrorDecoder())
    }

    @Bean
    fun blipClient(): BlipFeignClient {
        return clientBuilder().target(BlipFeignClient::class.java, apiUrl)
    }
}
