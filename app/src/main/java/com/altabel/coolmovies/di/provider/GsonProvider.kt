package com.altabel.coolmovies.di.provider

import com.altabel.coolmovies.model.data.server.DateDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.*
import javax.inject.Inject
import javax.inject.Provider

class GsonProvider @Inject constructor() : Provider<Gson> {

    override fun get(): Gson =
        GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateDeserializer())
            .create()
}