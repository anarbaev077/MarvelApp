package com.example.moviekinoapp.presentation.screens.splash

sealed interface SplashScreenAction {
    data object NavigateToMainGraph: SplashScreenAction
}