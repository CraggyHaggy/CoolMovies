package com.altabel.coolmovies.presentation.movies.popular

import com.altabel.coolmovies.entity.Movie
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PopularMoviesView : MvpView {

    fun showEmptyProgress(visible: Boolean)
    fun showPageProgress(visible: Boolean)
    fun showEmptyView(visible: Boolean)
    fun showEmptyError(visible: Boolean, message: String?)
    fun setMovies(movies: List<Movie>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(message: String)
}