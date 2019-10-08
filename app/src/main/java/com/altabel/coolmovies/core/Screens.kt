package com.altabel.coolmovies.core

import com.altabel.coolmovies.ui.MoviesFlowFragment
import com.altabel.coolmovies.ui.movies.MoviesContainerFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MainFlow : SupportAppScreen() {
        override fun getFragment() = MoviesFlowFragment()
    }

    object MoviesContainerScreen : SupportAppScreen() {
        override fun getFragment() = MoviesContainerFragment()
    }
}