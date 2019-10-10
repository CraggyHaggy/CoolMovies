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

    fun onBackPressed() {
        flowRouter.exit()
    }
}