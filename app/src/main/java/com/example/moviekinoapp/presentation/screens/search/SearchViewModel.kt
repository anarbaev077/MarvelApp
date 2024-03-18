package com.example.moviekinoapp.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.search.FetchSearchMovieByQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: FetchSearchMovieByQueryUseCase
) : ViewModel() {

    private val _uiAction: MutableSharedFlow<SearchAction> = MutableSharedFlow()
    val uiAction: SharedFlow<SearchAction> = _uiAction.asSharedFlow()

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.onSearchMovies -> onSearchMovie(event)
        }
    }

    private fun onSearchMovie(event: SearchEvent.onSearchMovies) {
        viewModelScope.launch {
            val request = searchUseCase(event.movieTitle)
            if (request.isSuccess) {
                _uiAction.emit(
                    SearchAction.FilteredMoviesBySearch(request.getOrNull().orEmpty())
                )
            }
        }
    }

}