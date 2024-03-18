package com.example.moviekinoapp.presentation.screens.detail.pager.cast

import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain

sealed interface CastAction {

    data class FetchCastDetail(
        val castDetail: MovieCastModelDomain
    ): CastAction
}