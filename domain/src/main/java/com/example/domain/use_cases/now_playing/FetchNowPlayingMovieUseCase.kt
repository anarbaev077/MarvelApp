package com.example.domain.use_cases.now_playing

import com.example.domain.models.movie_list_domain.MovieDomainModel

interface FetchNowPlayingMovieUseCase {

    suspend operator fun invoke(
        page:Int
    ):Result<List<MovieDomainModel>>

}