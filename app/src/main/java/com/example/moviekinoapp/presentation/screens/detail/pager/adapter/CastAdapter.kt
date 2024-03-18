package com.example.moviekinoapp.presentation.screens.detail.pager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.movie_details_domain.movie_cast.CastDomain
import com.example.moviekinoapp.R
import com.example.moviekinoapp.presentation.screens.home.adapter.CastItemDiffUtil

class CastAdapter : ListAdapter<CastDomain, CastAdapter.CastViewHolder>(CastItemDiffUtil()) {

    inner class CastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val actorPoster: ImageView = view.findViewById(R.id.actorsPhoto)
        private val actorName: TextView = view.findViewById(R.id.nameActor)
        private val characterName: TextView = view.findViewById(R.id.title_persons)
        private val popularityActors: TextView = view.findViewById(R.id.star_for_persons)


        fun bind(model: CastDomain) {
            Glide.with(itemView.context)
                .load(model.profilePath)
                .into(actorPoster)

            popularityActors.text = model.popularity.toString()
            actorName.text = model.name
            characterName.text = model.character
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cast_actors_items, parent, false)
        return CastViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}