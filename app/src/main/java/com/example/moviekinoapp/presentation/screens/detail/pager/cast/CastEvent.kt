package com.example.moviekinoapp.presentation.screens.detail.pager.cast

sealed interface CastEvent {
    data object OnFetchCastDetails: CastEvent
}