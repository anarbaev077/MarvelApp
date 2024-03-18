package com.example.moviekinoapp.presentation.screens.search

import com.example.domain.models.movie_list_domain.MovieDomainModel

sealed interface SearchAction {

    data class FilteredMoviesBySearch(
        val movies: List<MovieDomainModel>
    ): SearchAction

}