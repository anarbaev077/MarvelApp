package com.example.moviekinoapp.presentation.screens.detail.pager.more

import com.example.domain.models.movie_list_domain.MovieDomainModel

sealed interface MoreDetailAction {


    data class FetchAllMovies(
        val topRatedMovies: List<MovieDomainModel>,
    ) : MoreDetailAction

    data class NavigateToDetailsScreen(
        val movieId: Int
    ): MoreDetailAction


    data object ShowSuccessSnackBar: MoreDetailAction

}