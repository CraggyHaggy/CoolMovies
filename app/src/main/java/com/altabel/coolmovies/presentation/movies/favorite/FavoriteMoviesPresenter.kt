package com.altabel.coolmovies.presentation.movies.favorite

import com.altabel.coolmovies.core.BasePresenter
import com.altabel.coolmovies.core.ErrorHandler
import com.altabel.coolmovies.core.FlowRouter
import com.altabel.coolmovies.model.interactor.MovieInteractor
import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class FavoriteMoviesPresenter @Inject constructor(
    private val interactor: MovieInteractor,
    private val flowRouter: FlowRouter,
    private val errorHandler: ErrorHandler
) : BasePresenter<FavoriteMoviesView>() {

    private var isFirstEmit = true

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        interactor.getFavoriteMovies()
            .doOnSubscribe { viewState.showEmptyProgress(true) }
            .doOnNext {
                if (isFirstEmit) {
                    viewState.showEmptyProgress(false)
                }
            }
            .subscribe(
                { movies ->
                    if (isFirstEmit) {
                        isFirstEmit = false
                    }

                    if (movies.isNotEmpty()) {
                        viewState.setMovies(movies)
                        viewState.showEmptyView(false)
                    } else {
                        viewState.showEmptyView(true)
                    }
                },
                { throwable ->
                    if (isFirstEmit) {
                        viewState.showEmptyError(true)
                        isFirstEmit = false
                    } else {
                        errorHandler.handleError(throwable) { viewState.showMessage(it) }
                    }
                }
            )
            .connect()
    }
}