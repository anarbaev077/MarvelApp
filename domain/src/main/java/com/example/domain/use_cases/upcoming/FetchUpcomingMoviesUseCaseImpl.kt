package com.example.domain.use_cases.upcoming

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository

class FetchUpcomingMoviesUseCaseImpl(
    private val repository: MovieRepository
):FetchUpcomingMoviesUseCase {
    override suspend fun invoke(page: Int): Result<List<MovieDomainModel>> {
        return repository.fetchUpcomingMovie(page)
    }
}