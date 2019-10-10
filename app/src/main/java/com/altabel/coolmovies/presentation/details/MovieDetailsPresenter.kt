package com.altabel.coolmovies.presentation.details

import com.altabel.coolmovies.core.BasePresenter
import com.altabel.coolmovies.core.ErrorHandler
import com.altabel.coolmovies.core.FlowRouter
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.model.interactor.MovieInteractor
import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class MovieDetailsPresenter @Inject constructor(
    private val movie: Movie,
    private val interactor: MovieInteractor,
    private val flowRouter: FlowRouter,
    private val errorHandler: ErrorHandler
) : BasePresenter<MovieDetailsView>() {

    private var isFavorite = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setMovie(movie)
        interactor.isMovieFavorite(movie.id)
            .subscribe(
                {
                    isFavorite = it
                    viewState.setFavoriteState(it)
                },
                { throwable -> errorHandler.handleError(throwable) { viewState.showMessage(it) } }
            )
            .connect()
    }

    fun onFavoriteClicked() {
        if (isFavorite) {
            removeFavorite()
        } else {
            saveFavorite()
        }
    }

    private fun saveFavorite() {
        interactor.saveFavoriteMovie(movie)
            .subscribe(
                {},
                { throwable -> errorHandler.handleError(throwable) { viewState.showMessage(it) } }
            )
            .connect()
    }

    private fun removeFavorite() {
        interactor.removeFavoriteMovie(movie)
            .subscribe(
                {},
                { throwable -> errorHandler.handleError(throwable) { viewState.showMessage(it) } }
            )
            .connect()
    }

    fun onBackPressed() {
        flowRouter.exit()
    }
}