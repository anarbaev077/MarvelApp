package com.example.domain.use_cases.top_rated

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository

class FetchTopRatedMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchTopRatedMovieUseCase {
    override suspend fun invoke(page: Int): Result<List<MovieDomainModel>> {
        return repository.fetchTopRatedMovie(page)
    }
}