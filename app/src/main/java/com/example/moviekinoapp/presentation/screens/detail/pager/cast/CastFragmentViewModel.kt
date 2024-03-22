package com.example.moviekinoapp.presentation.screens.detail.pager.cast

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain
import com.example.domain.use_cases.details.cast_detail.FetchCastDetailsMovieUseCase
import com.example.moviekinoapp.presentation.screens.detail.pager.cast.CastAction
import com.example.moviekinoapp.presentation.screens.detail.pager.cast.CastEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CastFragmentViewModel @Inject constructor(
    private val castDetail: FetchCastDetailsMovieUseCase
): ViewModel() {

    private val _uiAction: MutableSharedFlow<CastAction> = MutableSharedFlow()
    val uiAction: SharedFlow<CastAction> = _uiAction.asSharedFlow()

    fun onEvent(event: CastEvent, movieId: Int){
        when(event){
            is CastEvent.OnFetchCastDetails -> onFetchCastDetails(movieId)
        }
    }

    private fun onFetchCastDetails(movieId: Int){
        viewModelScope.launch {
            val castResponseDeffered = async {
                castDetail(movieId = movieId)
            }

            val castDetails = castResponseDeffered.await()
            if (castDetails.isSuccess){
                _uiAction.emit(
                    CastAction.FetchCastDetail(
                        castDetail = castDetails.getOrNull() ?: MovieCastModelDomain.unknown
                    )
                )
            }
        }
    }

}