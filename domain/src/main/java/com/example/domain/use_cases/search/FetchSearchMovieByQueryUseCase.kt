package com.example.domain.use_cases.search

import com.example.domain.models.movie_list_domain.MovieDomainModel

interface FetchSearchMovieByQueryUseCase {
    suspend operator fun invoke(
        movieTitle: String
    ):Result<List<MovieDomainModel>>
}