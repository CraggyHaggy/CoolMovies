package com.altabel.coolmovies.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.altabel.coolmovies.R
import com.altabel.coolmovies.entity.Movie
import com.altabel.coolmovies.extension.formatUi
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView = itemView

    fun bind(movie: Movie) {
        with(containerView) {
            titleView.text = movie.title
            overviewView.text = movie.overview
            releaseDateView.text = movie.releaseDate.formatUi()

            Glide.with(posterImageView)
                .load(movie.posterPath)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.movie_default)
                        .error(R.drawable.movie_default)
                )
                .into(posterImageView)
        }
    }
}