package com.example.domain.use_cases.top_rated

import com.example.domain.models.movie_list_domain.MovieDomainModel

interface FetchTopRatedMovieUseCase {

    suspend operator fun invoke(page: Int): Result<List<MovieDomainModel>>

}