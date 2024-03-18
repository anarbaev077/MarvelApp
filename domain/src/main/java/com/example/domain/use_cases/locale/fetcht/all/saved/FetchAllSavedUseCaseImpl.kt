package com.example.domain.use_cases.locale.fetcht.all.saved

import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class FetchAllSavedUseCaseImpl(
    private val repository: MovieRepository
):FetchAllSavedUseCase {
    override fun invoke(): Flow<List<MovieDomainModel>> {
        return repository.fetchAllSavedMovies()
    }
}