package com.example.domain.use_cases.locale.save

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository

class SaveMovieToCacheUseCaseImpl(
    private val repository: MovieRepository
): SaveMovieToCacheUseCase {
    override suspend fun invoke(movieModel: MovieDomainModel) {
        repository.saveMoviesToCache(movieModel)
    }
}