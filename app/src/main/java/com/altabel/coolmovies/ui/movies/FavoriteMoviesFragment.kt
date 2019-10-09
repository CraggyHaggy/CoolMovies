package com.altabel.coolmovies.ui.movies

import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.extension.showSnackMessage
import com.altabel.coolmovies.extension.visible
import com.altabel.coolmovies.presentation.movies.favorite.FavoriteMoviesPresenter
import com.altabel.coolmovies.presentation.movies.favorite.FavoriteMoviesView
import com.altabel.coolmovies.ui.movies.adapter.MovieAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.layout_list.*
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

    private val movieAdapter = MovieAdapter({})

    override fun showEmptyProgress(visible: Boolean) {
        emptyProgress.visible(visible)
    }

    override fun setMovies(movies: List<Movie>) {
        movieAdapter.setItems(movies)
    }

    override fun showMessage(message: String) {
        showSnackMessage(message)
    }
}