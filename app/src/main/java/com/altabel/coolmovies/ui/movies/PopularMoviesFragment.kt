package com.altabel.coolmovies.ui.movies

import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.presentation.movies.popular.PopularMoviesPresenter
import com.altabel.coolmovies.presentation.movies.popular.PopularMoviesView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import toothpick.Scope

class PopularMoviesFragment : BaseFragment(), PopularMoviesView {

    override val layoutRes = R.layout.fragment_popular_movies

    override fun installScopeModules(scope: Scope) {
    }

    @InjectPresenter
    lateinit var presenter: PopularMoviesPresenter

    @ProvidePresenter
    fun providePresenter(): PopularMoviesPresenter =
        scope.getInstance(PopularMoviesPresenter::class.java)

    override fun showRefreshProgress(show: Boolean) {
    }

    override fun showEmptyProgress(show: Boolean) {
    }

    override fun showPageProgress(show: Boolean) {
    }

    override fun showEmptyView(show: Boolean) {
    }

    override fun showEmptyError(show: Boolean, message: String?) {
    }

    override fun showMovies(show: Boolean, movies: List<Movie>) {
    }

    override fun showMessage(message: String) {
    }
}