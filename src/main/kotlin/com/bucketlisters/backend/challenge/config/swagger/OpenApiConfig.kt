package com.bucketlisters.backend.challenge.config.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun myOpenAPI(): OpenAPI {

        val contact = Contact()
        contact.email = "product@bucketlisters.com"
        contact.name = "Bucket Listers Product Team"
        contact.url = "https://bucketlisters.com"

        val info = Info().title("Bucket Listers Backend Challenge").version("1.0")

        return OpenAPI().info(info)
    }
}
