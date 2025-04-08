package com.bucketlisters.backend.challenge.config.gson.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class LocalTimeTypeAdapter : TypeAdapter<LocalTime>() {

    override fun write(out: JsonWriter, value: LocalTime) {
        out.value(DateTimeFormatter.ISO_LOCAL_TIME.format(value))
    }

    override fun read(input: JsonReader): LocalTime = LocalTime.parse(input.nextString())
}
