package com.example.moviekinoapp.presentation.screens.detail.pager.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.locale.save.SaveMovieToCacheUseCase
import com.example.domain.use_cases.top_rated.FetchTopRatedMovieUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoreDetailViewModel @Inject constructor(
    private val fetchTopRatedMovieUseCase: FetchTopRatedMovieUseCase,
) : ViewModel() {

    private val _uiAction: MutableSharedFlow<MoreDetailAction> = MutableSharedFlow()
    val uiAction: SharedFlow<MoreDetailAction> = _uiAction.asSharedFlow()

    fun onEvent(event: MoreDetailEvent) {
        when (event) {
            is MoreDetailEvent.OnFetchTopRatedMovies -> onFetchAllMovies()
//            is MoreDetailEvent.OnNavigateToDetails -> onNavigateToDetailsScreen(event)
        }
    }
//
//    private fun onNavigateToDetailsScreen(event: MoreDetailEvent.OnNavigateToDetails){
//        viewModelScope.launch {
//            _uiAction.emit(MoreDetailAction.NavigateToDetailsScreen(event.movieId))
//        }
//    }

    private fun onFetchAllMovies() {
        viewModelScope.launch {
            val topRatedResponseDeferred = async {
                fetchTopRatedMovieUseCase(page = 1)
            }
            val topRatedMovies = topRatedResponseDeferred.await()

            if (topRatedMovies.isSuccess) {
                _uiAction.emit(
                    MoreDetailAction.FetchAllMovies(
                        topRatedMovies = topRatedMovies.getOrNull().orEmpty(),
                    )
                )
            }
        }
    }
}