package com.altabel.coolmovies.core

import com.altabel.coolmovies.ui.MoviesFlowFragment
import com.altabel.coolmovies.ui.movies.MoviesContainerFragment
import com.altabel.coolmovies.ui.movies.MoviesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MoviesFlow : SupportAppScreen() {
        override fun getFragment() = MoviesFlowFragment()
    }

    object MoviesContainerScreen : SupportAppScreen() {
        override fun getFragment() = MoviesContainerFragment()
    }

    data class MoviesScreen(
        private val isPopular: Boolean
    ) : SupportAppScreen() {

        override fun getFragment() = MoviesFragment()
    }
}