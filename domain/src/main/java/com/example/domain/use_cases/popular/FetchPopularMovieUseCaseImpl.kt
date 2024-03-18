package com.example.domain.use_cases.popular

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository
import com.example.domain.use_cases.now_playing.FetchNowPlayingMovieUseCase

class FetchPopularMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchPopularMovieUseCase, FetchNowPlayingMovieUseCase {
    override suspend fun invoke(page: Int): Result<List<MovieDomainModel>> {
        return repository.fetchPopularMovie(page = page)
    }
}