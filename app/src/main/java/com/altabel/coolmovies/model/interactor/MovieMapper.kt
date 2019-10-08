package com.altabel.coolmovies.model.interactor

import com.altabel.coolmovies.entity.ApiMovie
import com.altabel.coolmovies.entity.FavoriteMovie
import com.altabel.coolmovies.entity.Movie

class MovieMapper {

    fun mapApiMovie(apiMovie: ApiMovie): Movie {
        return with(apiMovie) {
            Movie(
                id,
                popularity,
                voteCount,
                video,
                posterPath,
                adult,
                backdropPath,
                originalLanguage,
                originalTitle,
                genreIds,
                title,
                voteAverage,
                overview,
                releaseDate
            )
        }
    }

    fun mapFavoriteMovie(favoriteMovie: FavoriteMovie): Movie {
        return with(favoriteMovie) {
            Movie(
                id,
                popularity,
                voteCount,
                video,
                posterPath,
                adult,
                backdropPath,
                originalLanguage,
                originalTitle,
                genreIds,
                title,
                voteAverage,
                overview,
                releaseDate
            )
        }
    }

    fun mapMovie(movie: Movie): FavoriteMovie {
        return with(movie) {
            FavoriteMovie(
                id,
                popularity,
                voteCount,
                video,
                posterPath,
                adult,
                backdropPath,
                originalLanguage,
                originalTitle,
                genreIds,
                title,
                voteAverage,
                overview,
                releaseDate
            )
        }
    }
}