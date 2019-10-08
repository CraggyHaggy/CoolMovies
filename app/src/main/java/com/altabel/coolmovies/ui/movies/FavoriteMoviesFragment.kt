package com.altabel.coolmovies.ui.movies

import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.presentation.movies.favorite.FavoriteMoviesPresenter
import com.altabel.coolmovies.presentation.movies.favorite.FavoriteMoviesView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import toothpick.Scope

class FavoriteMoviesFragment : BaseFragment(), FavoriteMoviesView {

    override val layoutRes = R.layout.fragment_favorite_movies

    override fun installScopeModules(scope: Scope) {
    }

    @InjectPresenter
    lateinit var presenter: FavoriteMoviesPresenter

    @ProvidePresenter
    fun providePresenter(): FavoriteMoviesPresenter = scope.getInstance(
        FavoriteMoviesPresenter::class.java
    )

    override fun setMovies(movies: List<Movie>) {
    }

    override fun showEmptyProgress(visible: Boolean) {
    }

    override fun showMessage(message: String) {
    }
}