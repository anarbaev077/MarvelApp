package com.example.moviekinoapp.presentation.screens.splash

sealed interface SplashScreenEvent {

    data object OnNavigateToMainNavGraphAfterTenSeconds: SplashScreenAction, SplashScreenEvent
}