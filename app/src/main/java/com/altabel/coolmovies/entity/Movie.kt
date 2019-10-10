package com.altabel.coolmovies.entity

import java.io.Serializable
import java.util.*

data class Movie(
    val id: Int,
    val popularity: Float,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val voteAverage: Float,
    val overview: String,
    val releaseDate: Date
) : Serializable