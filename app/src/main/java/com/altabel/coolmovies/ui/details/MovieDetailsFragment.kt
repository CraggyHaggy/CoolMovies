package com.altabel.coolmovies.ui.details

import android.os.Bundle
import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.extension.formatUi
import com.altabel.coolmovies.extension.showSnackMessage
import com.altabel.coolmovies.presentation.details.MovieDetailsPresenter
import com.altabel.coolmovies.presentation.details.MovieDetailsView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_movie_details.*
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

    override fun setMovie(movie: Movie) {
        toolbar.title = movie.title
        overviewView.text = movie.overview
        releaseDateView.text = getString(R.string.movie_release_date, movie.releaseDate.formatUi())
        voteCountView.text = getString(R.string.movie_vote_count, movie.voteCount)
        voteAverageView.text = getString(R.string.movie_vote_average, movie.voteAverage)
        popularityView.text = getString(R.string.movie_popularity, movie.popularity)

        Glide.with(posterImageView)
            .load(movie.posterPath)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.movie_default)
                    .error(R.drawable.movie_default)
            )
            .into(posterImageView)
    }

    override fun setFavoriteState(favorite: Boolean) {
        val icon = if (favorite) {
            R.drawable.ic_favorite_24dp
        } else {
            R.drawable.ic_not_favorite_24dp
        }
        favoriteButton.setImageResource(icon)
    }

    override fun showMessage(message: String) {
        showSnackMessage(message)
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