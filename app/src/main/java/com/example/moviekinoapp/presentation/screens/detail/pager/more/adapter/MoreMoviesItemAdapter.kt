package com.example.moviekinoapp.presentation.screens.detail.pager.more.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.moviekinoapp.R
import com.example.moviekinoapp.presentation.screens.home.adapter.ItemOnClickListeners
import com.example.moviekinoapp.presentation.screens.home.adapter.MoreMovieItemTypes
import com.example.moviekinoapp.presentation.screens.home.adapter.MovieItemDiffUtil


class MoreMoviesItemAdapter(
    private val itemTypes: MoreMovieItemTypes,
    private val itemsOnClickListeners: ItemOnClickListeners
) : ListAdapter<MovieDomainModel, MoreMoviesItemAdapter.MoviesItemViewHolder>(
    MovieItemDiffUtil()
) {
    inner class MoviesItemViewHolder(
        view: View
    ) : ViewHolder(view) {
        private val moviePoster = view.findViewById<ImageView>(R.id.moviePoster)
        private val nameMovie: TextView = view.findViewById(R.id.nameMovie)
        private val popularMovie: TextView = view.findViewById(R.id.ratingMovies)
        private val ratingMovie: TextView = view.findViewById(R.id.ratingMovies)
        private val releaseDate: TextView = view.findViewById(R.id.releaseDate)

        fun bind(model: MovieDomainModel) {
            Glide
                .with(itemView.context)
                .load(model.posterPath)
                .into(moviePoster)

            popularMovie.text = model.popularity.toString()
            nameMovie.text = model.title
            ratingMovie.text = model.rating.toString()
            releaseDate.text = model.releaseDate

            moviePoster.setOnClickListener {
                itemsOnClickListeners.onMovieItemClick(model.id ?: 0)
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
                MoreMovieItemTypes.TOP_RATED -> R.layout.list_for_latest_movies
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