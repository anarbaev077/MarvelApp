package com.example.moviekinoapp.presentation.screens.home.adapter

import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.moviekinoapp.R

interface ItemOnClickListeners {
    fun onMovieItemClick(movieId: Int)

    fun onMovieLongClick(movieDomainModel: MovieDomainModel)
}

class MoviesItemAdapter(
    private val itemTypes: MovieItemTypes,
    private val itemsOnClickListeners: ItemOnClickListeners
) : ListAdapter<MovieDomainModel, MoviesItemAdapter.MoviesItemViewHolder>(
    MovieItemDiffUtil()
) {

    inner class MoviesItemViewHolder(
        view: View
    ) : ViewHolder(view) {
        private val moviePoster = view.findViewById<ImageView>(R.id.moviePoster)

        fun bind(model: MovieDomainModel) {
            Glide
                .with(itemView.context)
                .load(model.posterPath)
                .into(moviePoster)

            moviePoster.setOnClickListener{
                itemsOnClickListeners.onMovieItemClick(model.id ?:0)
            }

            moviePoster.setOnLongClickListener {
                itemsOnClickListeners.onMovieLongClick(model)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesItemViewHolder {
        val movieItem = LayoutInflater.from(parent.context).inflate(
            when (itemTypes) {
                MovieItemTypes.LATEST -> R.layout.movie_peeking_item
                MovieItemTypes.TRENDING -> R.layout.movie_default_items
                MovieItemTypes.TOP_RATED -> R.layout.movie_default_items
                MovieItemTypes.UPCOMING -> R.layout.movie_default_items
                MovieItemTypes.FAVORITES -> R.layout.favorites_items
            },
            parent,
            false
        )
        return MoviesItemViewHolder(movieItem)
    }

    override fun onBindViewHolder(holder: MoviesItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}