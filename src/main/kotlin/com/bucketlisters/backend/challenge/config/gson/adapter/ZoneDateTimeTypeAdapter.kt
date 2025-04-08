package com.bucketlisters.backend.challenge.config.gson.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ZoneDateTimeTypeAdapter : TypeAdapter<ZonedDateTime>() {
    override fun write(out: JsonWriter, value: ZonedDateTime) {
        out.value(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value))
    }

    override fun read(input: JsonReader): ZonedDateTime = ZonedDateTime.parse(input.nextString())
}
