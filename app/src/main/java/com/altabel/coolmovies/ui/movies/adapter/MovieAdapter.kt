package com.altabel.coolmovies.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.altabel.coolmovies.R
import com.altabel.coolmovies.entity.Movie

class MovieAdapter(
    private val onItemClickListener: (Movie) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Any>()

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ProgressItem -> R.layout.item_progress
            else -> R.layout.item_movie
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(viewType, parent, false)

        if (viewType == R.layout.item_movie) {
            val viewHolder = MovieViewHolder(itemView)
            itemView.setOnClickListener {
                val position = viewHolder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = items[position]
                    if (item is Movie) {
                        onItemClickListener(item)
                    }
                }
            }
            return viewHolder
        } else {
            return ProgressViewHolder(itemView)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieViewHolder) {
            holder.bind(items[position] as Movie)
        }
    }

    fun setItems(newItems: List<Movie>) {
        val progress = isProgress()
        val oldItems = items.toList()

        items.clear()
        items.addAll(newItems)
        if (progress) items.add(ProgressItem())

        DiffUtil
            .calculateDiff(DiffCallback(items, oldItems), false)
            .dispatchUpdatesTo(this)
    }

    fun showProgress(visible: Boolean) {
        val progress = isProgress()

        if (visible && !progress) {
            items.add(ProgressItem())
            notifyItemInserted(items.lastIndex)
        } else if (!visible && progress) {
            items.remove(items.last())
            notifyItemRemoved(items.size)
        }
    }

    private fun isProgress() = items.isNotEmpty() && items.last() is ProgressItem

    private inner class DiffCallback(
        private val newItems: List<Any>,
        private val oldItems: List<Any>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldItems.size
        override fun getNewListSize() = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            return if (newItem is Movie && oldItem is Movie) {
                newItem.id == oldItem.id
            } else {
                newItem is ProgressItem && oldItem is ProgressItem
            }
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            return if (newItem is Movie && oldItem is Movie) {
                newItem == oldItem
            } else {
                true
            }
        }
    }
}