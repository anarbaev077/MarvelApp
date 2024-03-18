package com.example.moviekinoapp.presentation.screens.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.movie_details_domain.movie_cast.CastDomain
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.models.person_models_domain.ResultDomain

class MovieItemDiffUtil : DiffUtil.ItemCallback<MovieDomainModel>() {

    override fun areItemsTheSame(
        oldItem: MovieDomainModel,
        newItem: MovieDomainModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: MovieDomainModel,
        newItem: MovieDomainModel
    ): Boolean = oldItem == newItem

}
class CastItemDiffUtil : DiffUtil.ItemCallback<CastDomain>() {

    override fun areItemsTheSame(
        oldItem: CastDomain,
        newItem: CastDomain
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: CastDomain,
        newItem: CastDomain
    ): Boolean = oldItem == newItem

}

class ActorsItemDiffUtil : DiffUtil.ItemCallback<ResultDomain>() {

    override fun areItemsTheSame(
        oldItem: ResultDomain,
        newItem: ResultDomain
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ResultDomain,
        newItem: ResultDomain
    ): Boolean = oldItem == newItem

}