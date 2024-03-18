package com.example.moviekinoapp.presentation.screens.person

sealed interface PersonEvent {

    data object OnFetchPopularPerson: PersonEvent

}