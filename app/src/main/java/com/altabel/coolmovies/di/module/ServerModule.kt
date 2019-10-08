package com.altabel.coolmovies.di.module

import com.google.gson.Gson
import com.altabel.coolmovies.di.Qualifiers
import com.altabel.coolmovies.di.provider.GsonProvider
import com.altabel.coolmovies.di.provider.OkHttpClientProvider
import com.altabel.coolmovies.di.provider.ServerApiProvider
import com.altabel.coolmovies.model.data.server.ServerApi
import okhttp3.OkHttpClient
import toothpick.config.Module

class ServerModule : Module() {

    init {
        // Network
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java)
            .providesSingletonInScope()
        bind(Gson::class.java).toProvider(GsonProvider::class.java).providesSingletonInScope()
        bind(String::class.java).withName(Qualifiers.ServerPath::class.java)
            .toInstance("https://api.themoviedb.org/3/movie/")
        bind(ServerApi::class.java).toProvider(ServerApiProvider::class.java)
            .providesSingletonInScope()
    }
}