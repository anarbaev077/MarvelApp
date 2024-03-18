package com.example.domain.use_cases.details.cast_detail

import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain
import com.example.domain.repository.MovieRepository

class FetchCastDetailsMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchCastDetailsMovieUseCase {
    override suspend fun invoke(movieId: Int): Result<MovieCastModelDomain> {
        return repository.fetchCastDetailMovie(movieId)
    }
}