package com.altabel.coolmovies.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class ProgressViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView = itemView
}