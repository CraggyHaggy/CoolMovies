package com.altabel.coolmovies.ui.movies

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.extension.dpToPx
import com.altabel.coolmovies.extension.showSnackMessage
import com.altabel.coolmovies.extension.visible
import com.altabel.coolmovies.presentation.movies.popular.PopularMoviesPresenter
import com.altabel.coolmovies.presentation.movies.popular.PopularMoviesView
import com.altabel.coolmovies.ui.movies.adapter.MovieAdapter
import com.altabel.coolmovies.ui.movies.adapter.SpaceItemDecoration
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.layout_list.*
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

    private val movieAdapter = MovieAdapter { presenter.onMovieClicked(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(SpaceItemDecoration(context.dpToPx(16f)))
            adapter = movieAdapter
        }
    }

    override fun showEmptyProgress(visible: Boolean) {
        emptyProgress.visible(visible)
    }

    override fun showPageProgress(visible: Boolean) {
        movieAdapter.showProgress(visible)
    }

    override fun showEmptyView(visible: Boolean) {
        if (visible) {
            emptyView.text = getString(R.string.empty_data_description)
        }
        emptyView.visible(visible)
    }

    override fun showEmptyError(visible: Boolean, message: String?) {
        if (visible) {
            emptyView.text = getString(R.string.empty_data_description)
        }
        emptyView.visible(visible)
    }

    override fun setMovies(movies: List<Movie>) {
        movieAdapter.setItems(movies)
    }

    override fun showMessage(message: String) {
        showSnackMessage(message)
    }
}