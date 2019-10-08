package com.altabel.coolmovies.model.interactor

import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.model.data.server.ServerApi
import com.altabel.coolmovies.model.local.FavoriteMovieDao
import com.altabel.coolmovies.model.system.scheduler.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class MovieInteractor(
    private val serverApi: ServerApi,
    private val favoriteMovieDao: FavoriteMovieDao,
    private val movieMapper: MovieMapper,
    private val schedulesProvider: SchedulersProvider
) {

    fun getPopularMovies(page: Int): Single<List<Movie>> =
        serverApi
            .getPopularMovies(page)
            .map { apiMoviePage -> apiMoviePage.results.map { movieMapper.mapApiMovie(it) } }
            .subscribeOn(schedulesProvider.io())
            .observeOn(schedulesProvider.ui())

    fun getFavoriteMovies(): Observable<List<Movie>> =
        favoriteMovieDao
            .getAll()
            .map { favoriteMovies -> favoriteMovies.map { movieMapper.mapFavoriteMovie(it) } }
            .subscribeOn(schedulesProvider.io())
            .observeOn(schedulesProvider.ui())

    fun saveFavoriteMovie(movie: Movie) =
        Completable
            .fromAction { favoriteMovieDao.insert(movieMapper.mapMovie(movie)) }
            .subscribeOn(schedulesProvider.io())
            .observeOn(schedulesProvider.ui())

    fun removeFavoriteMovie(movie: Movie) =
        Completable
            .fromAction { favoriteMovieDao.delete(movieMapper.mapMovie(movie)) }
            .subscribeOn(schedulesProvider.io())
            .observeOn(schedulesProvider.ui())
}