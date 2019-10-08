package com.altabel.coolmovies.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "movies")
data class FavoriteMovie(
    @PrimaryKey val id: Int,
    val popularity: Int,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val voteAverage: Int,
    val overview: String,
    val releaseDate: Date
)