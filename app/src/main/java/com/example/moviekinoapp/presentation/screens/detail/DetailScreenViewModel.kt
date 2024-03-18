package com.example.moviekinoapp.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.movie_details_domain.MovieDetailModelDomain
import com.example.domain.use_cases.details.FetchDetailMovieUseCase
import com.example.moviekinoapp.presentation.screens.detail.DetailScreenAction
import com.example.moviekinoapp.presentation.screens.detail.DetailScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val detailMovieUseCase: FetchDetailMovieUseCase
) : ViewModel() {

    private val _uiAction: MutableSharedFlow<DetailScreenAction> = MutableSharedFlow()
    val uiAction: SharedFlow<DetailScreenAction> = _uiAction.asSharedFlow()

    fun onEvent(event: DetailScreenEvent, movieId: Int){
        when (event){
            is DetailScreenEvent.OnFetchDetailMovie -> onFetchDetailMovies(movieId)
        }
    }

    private fun onFetchDetailMovies(movieId: Int) {
        viewModelScope.launch {
            val detailResponseDeferred = async {
                detailMovieUseCase(movieId = movieId)
            }

            val detailMovie = detailResponseDeferred.await()

            if (detailMovie.isSuccess){
                _uiAction.emit(
                    DetailScreenAction.FetchDetailMovie(
                        detailMovie = detailMovie.getOrNull() ?: MovieDetailModelDomain.unknown
                    )
                )
            }
        }
    }
}