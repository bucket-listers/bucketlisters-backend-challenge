package com.bucketlisters.backend.challenge.integration.config

import com.bucketlisters.backend.challenge.config.error.exceptions.CustomException
import feign.Response
import feign.codec.ErrorDecoder

class BlipErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String?, response: Response): Exception? {
        return CustomException(
            error = "External Integration [$methodKey] - ${response.body()}",
            code = response.status(),
        )
    }
}
