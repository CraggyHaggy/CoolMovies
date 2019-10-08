package com.altabel.coolmovies.entity

import com.google.gson.annotations.SerializedName

data class ApiMoviePage(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<ApiMovie>
)