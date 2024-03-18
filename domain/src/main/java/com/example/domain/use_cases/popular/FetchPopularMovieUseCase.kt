package com.example.domain.use_cases.popular

import com.example.domain.models.movie_list_domain.MovieDomainModel

interface FetchPopularMovieUseCase {
    suspend operator fun invoke(
        page:Int
    ):Result<List<MovieDomainModel>>
}