package com.example.moviekinoapp.presentation.screens.home

import com.example.domain.models.movie_list_domain.MovieDomainModel

sealed interface HomeScreenEvent {

    data object OnFetchAllMovies: HomeScreenEvent

    data class OnNavigateToDetails(val movieId: Int) : HomeScreenEvent

    data class OnSaveMovieToCache(val movie: MovieDomainModel): HomeScreenEvent

}