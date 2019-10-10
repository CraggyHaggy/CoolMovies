package com.altabel.coolmovies.presentation.movies.popular

import com.altabel.coolmovies.core.BasePresenter
import com.altabel.coolmovies.core.ErrorHandler
import com.altabel.coolmovies.core.FlowRouter
import com.altabel.coolmovies.core.Screens
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.model.interactor.MovieInteractor
import com.altabel.coolmovies.presentation.global.Paginator
import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class PopularMoviesPresenter @Inject constructor(
    private val interactor: MovieInteractor,
    private val flowRouter: FlowRouter,
    private val errorHandler: ErrorHandler
) : BasePresenter<PopularMoviesView>() {

    private val paginator = Paginator(
        { page -> interactor.getPopularMovies(page) },
        object : Paginator.ViewController<Movie> {

            override fun showEmptyProgress(show: Boolean) {
                viewState.showEmptyProgress(show)
            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {
                if (error != null) {
                    errorHandler.handleError(error) { viewState.showEmptyError(show, it) }
                } else {
                    viewState.showEmptyError(show, null)
                }
            }

            override fun showErrorMessage(error: Throwable) {
                errorHandler.handleError(error) { viewState.showMessage(it) }
            }

            override fun showEmptyView(show: Boolean) {
                viewState.showEmptyView(show)
            }

            override fun showData(show: Boolean, data: List<Movie>) {
                if (show) {
                    viewState.setMovies(data)
                }
            }

            override fun showPageProgress(show: Boolean) {
                viewState.showPageProgress(show)
            }
        }
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        paginator.restart()
    }

    override fun onDestroy() {
        super.onDestroy()

        paginator.release()
    }

    fun onMovieClicked(movie: Movie) {
        flowRouter.navigateTo(Screens.MovieDetailsScreen(movie))
    }
}