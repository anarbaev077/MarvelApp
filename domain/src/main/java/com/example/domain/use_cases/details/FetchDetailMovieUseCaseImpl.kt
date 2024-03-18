package com.example.domain.use_cases.details

import com.example.domain.models.movie_details_domain.MovieDetailModelDomain
import com.example.domain.repository.MovieRepository

class FetchDetailMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchDetailMovieUseCase {
    override suspend fun invoke(movieId: Int): Result<MovieDetailModelDomain> {
        return repository.fetchDetailMovie(movieId)
    }
}