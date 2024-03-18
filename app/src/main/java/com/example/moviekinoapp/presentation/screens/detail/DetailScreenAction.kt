package com.example.moviekinoapp.presentation.screens.detail

import com.example.domain.models.movie_details_domain.MovieDetailModelDomain

sealed interface DetailScreenAction {

    data class FetchDetailMovie(
        val detailMovie: MovieDetailModelDomain
    ): DetailScreenAction
}