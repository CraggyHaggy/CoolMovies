package com.altabel.coolmovies.core

import com.altabel.coolmovies.ui.MoviesFlowFragment
import com.altabel.coolmovies.ui.movies.FavoriteMoviesFragment
import com.altabel.coolmovies.ui.movies.MoviesContainerFragment
import com.altabel.coolmovies.ui.movies.PopularMoviesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MoviesFlow : SupportAppScreen() {
        override fun getFragment() = MoviesFlowFragment()
    }

    object MoviesContainerScreen : SupportAppScreen() {
        override fun getFragment() = MoviesContainerFragment()
    }

    object PopularMoviesScreen : SupportAppScreen() {
        override fun getFragment() = PopularMoviesFragment()
    }

    object FavoriteMoviesScreen : SupportAppScreen() {
        override fun getFragment() = FavoriteMoviesFragment()
    }
}