package com.altabel.coolmovies.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.altabel.coolmovies.R
import com.altabel.coolmovies.entity.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class MovieViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView = itemView

    private val releaseDateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    fun bind(movie: Movie) {
        with(containerView) {
            titleView.text = movie.title
            overviewView.text = movie.overview
            releaseDateView.text = releaseDateFormatter.format(movie.releaseDate)

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