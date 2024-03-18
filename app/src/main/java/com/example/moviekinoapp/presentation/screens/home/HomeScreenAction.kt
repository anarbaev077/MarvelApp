package com.example.moviekinoapp.presentation.screens.home

import com.example.domain.models.movie_list_domain.MovieDomainModel

sealed interface HomeScreenAction {

    data class FetchAllMovies(
        val popularMovies: List<MovieDomainModel>,
        val nowPlayingMovies: List<MovieDomainModel>,
        val topRatedMovies: List<MovieDomainModel>,
        val upcomingMovies: List<MovieDomainModel>
    ): HomeScreenAction

    data class NavigateToDetailsScreen(
        val movieId: Int
    ): HomeScreenAction

    data object UpdateScreenHideShimmer: HomeScreenAction

    data object ShowSuccessSnackBar: HomeScreenAction

}