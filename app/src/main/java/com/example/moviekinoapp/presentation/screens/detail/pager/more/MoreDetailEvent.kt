package com.example.moviekinoapp.presentation.screens.detail.pager.more

import com.example.domain.models.movie_list_domain.MovieDomainModel

sealed interface MoreDetailEvent {


    data object OnFetchTopRatedMovies: MoreDetailEvent
//
//    data class OnNavigateToDetails(val movieId: Int) : MoreDetailEvent

}