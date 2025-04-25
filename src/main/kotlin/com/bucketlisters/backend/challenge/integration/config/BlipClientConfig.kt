package com.bucketlisters.backend.challenge.integration.config

import com.bucketlisters.backend.challenge.integration.BlipFeignClient
import feign.Feign
import feign.Retryer
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.okhttp.OkHttpClient
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlipClientConfig(
    @Value("\${blip.api.url}") val apiUrl: String,
    val customFrontGateGsonEncoder: GsonEncoder,
    val customFrontGateGsonDecoder: GsonDecoder,
) {

    private fun clientBuilder(okHttpClient: OkHttpClient): Feign.Builder {
        return Feign.builder()
            .retryer(Retryer.Default())
            .client(okHttpClient)
            .encoder(customFrontGateGsonEncoder)
            .decoder(customFrontGateGsonDecoder)
            .errorDecoder(BlipErrorDecoder())
    }

    @Bean
    fun blipClient(okHttpClient: OkHttpClient): BlipFeignClient {
        return clientBuilder(okHttpClient).target(BlipFeignClient::class.java, apiUrl)
    }

    /** Customize OkHttpClient to ignore SSL certificate errors. */
    @Bean
    fun okHttpClient(): OkHttpClient {

        val trustAllCerts =
            arrayOf<TrustManager>(
                object : X509TrustManager {
                    override fun checkClientTrusted(
                        p0: Array<out X509Certificate?>?,
                        p1: String?,
                    ) {}

                    override fun checkServerTrusted(
                        p0: Array<out X509Certificate?>?,
                        p1: String?,
                    ) {}

                    override fun getAcceptedIssuers(): Array<out X509Certificate?>? {
                        return arrayOf()
                    }
                }
            )

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())

        val okHttpClient =
            okhttp3.OkHttpClient.Builder()
                .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0] as X509TrustManager)
                .hostnameVerifier { _, _ -> true }
                .build()

        return OkHttpClient(okHttpClient)
    }
}
