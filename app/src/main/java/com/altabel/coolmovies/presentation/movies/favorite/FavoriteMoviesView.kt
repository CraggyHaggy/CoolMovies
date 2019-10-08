package com.altabel.coolmovies.presentation.movies.favorite

import com.altabel.coolmovies.entity.Movie
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FavoriteMoviesView : MvpView {

    fun setMovies(movies: List<Movie>)

    fun showEmptyProgress(visible: Boolean)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(message: String)
}