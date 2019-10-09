package com.altabel.coolmovies.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.altabel.coolmovies.entity.Movie
import kotlinx.android.extensions.LayoutContainer

class MovieViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView = itemView

    fun bind(movie: Movie) {

    }
}