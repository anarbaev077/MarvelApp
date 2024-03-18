package com.example.moviekinoapp.presentation.screens.detail

sealed interface DetailScreenEvent {

    data object OnFetchDetailMovie: DetailScreenEvent

}