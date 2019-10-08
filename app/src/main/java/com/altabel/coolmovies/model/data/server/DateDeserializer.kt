package com.altabel.coolmovies.model.data.server

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date> {

    private val dateTimeFormatter = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())

    override fun deserialize(
        json: JsonElement,
        type: Type,
        jsonDeserializationContext: JsonDeserializationContext
    ): Date = dateTimeFormatter.parse(json.asJsonPrimitive.asString)
}