package com.example.domain.use_cases.details

import com.example.domain.models.movie_details_domain.MovieDetailModelDomain

interface FetchDetailMovieUseCase {

    suspend operator fun invoke(movieId: Int): Result<MovieDetailModelDomain>

}