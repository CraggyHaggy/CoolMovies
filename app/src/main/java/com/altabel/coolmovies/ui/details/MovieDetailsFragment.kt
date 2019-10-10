package com.altabel.coolmovies.ui.details

import android.os.Bundle
import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.presentation.details.MovieDetailsPresenter
import com.altabel.coolmovies.presentation.details.MovieDetailsView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import toothpick.Scope
import toothpick.config.Module

class MovieDetailsFragment : BaseFragment(), MovieDetailsView {

    override val layoutRes = R.layout.fragment_movie_details

    override fun installScopeModules(scope: Scope) {
        val args = arguments
        if (args != null && args.containsKey(EXTRAS_MOVIE)) {
            val movie = args.getSerializable(EXTRAS_MOVIE) as Movie
            scope.installModules(object : Module() {
                init {
                    bind(Movie::class.java).toInstance(movie)
                }
            })
        } else {
            throw IllegalArgumentException("Provide movie as argument!")
        }
    }

    @InjectPresenter
    lateinit var presenter: MovieDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): MovieDetailsPresenter =
        scope.getInstance(MovieDetailsPresenter::class.java)

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {

        private const val EXTRAS_MOVIE = "EXTRAS_MOVIE"

        fun newInstance(movie: Movie): MovieDetailsFragment {
            val args = Bundle()
            args.putSerializable(EXTRAS_MOVIE, movie)

            return MovieDetailsFragment().apply {
                arguments = args
            }
        }
    }
}