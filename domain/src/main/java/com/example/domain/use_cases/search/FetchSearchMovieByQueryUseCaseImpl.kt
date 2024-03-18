package com.example.domain.use_cases.search

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository

class FetchSearchMovieByQueryUseCaseImpl(
    private val repository: MovieRepository
):FetchSearchMovieByQueryUseCase {
    override suspend fun invoke(movieTitle: String): Result<List<MovieDomainModel>> {
        return repository.searchMovies(movieTitle)
    }
}