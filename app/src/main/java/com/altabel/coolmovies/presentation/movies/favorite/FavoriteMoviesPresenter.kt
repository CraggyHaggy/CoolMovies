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
            .doAfterNext {
                if (isFirstEmit) {
                    viewState.showEmptyProgress(false)
                    isFirstEmit = false
                }
            }
            .subscribe(
                { viewState.setMovies(it) },
                { throwable -> errorHandler.handleError(throwable) { viewState.showMessage(it) } }
            )
            .connect()
    }
}