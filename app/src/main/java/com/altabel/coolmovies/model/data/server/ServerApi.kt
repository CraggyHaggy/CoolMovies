package com.altabel.coolmovies.model.data.server

import com.altabel.coolmovies.entity.ApiMoviePage
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {

    @GET("popular?api_key=b66ffea8276ce576d60df52600822c88")
    fun getPopularMovies(
        @Query("page") page: Int
    ): Single<ApiMoviePage>
}