package com.example.moviekinoapp.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.locale.fetcht.all.saved.FetchAllSavedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val fetchAllSavedUseCase: FetchAllSavedUseCase
) : ViewModel() {

    private val _uiAction: MutableSharedFlow<FavoriteAction> = MutableSharedFlow()
    val uiAction: SharedFlow<FavoriteAction> = _uiAction.asSharedFlow()

    val savedMoviesFlow = fetchAllSavedUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun fetchAllSavedMovies() {
        viewModelScope.launch {
            val request = fetchAllSavedUseCase()
            _uiAction.emit(FavoriteAction.FavoriteMovies(savedMoviesFlow.value.orEmpty()))
        }
    }
}