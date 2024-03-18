package com.example.domain.use_cases.now_playing

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository

class FetchNowPlayingMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchNowPlayingMovieUseCase {
    override suspend fun invoke(page: Int): Result<List<MovieDomainModel>> {
        return repository.fetchNowPlayingMovie(page = page)
    }
}