package com.example.moviekinoapp.presentation.screens.search

sealed interface SearchEvent {

    data class onSearchMovies(val movieTitle: String): SearchEvent

}