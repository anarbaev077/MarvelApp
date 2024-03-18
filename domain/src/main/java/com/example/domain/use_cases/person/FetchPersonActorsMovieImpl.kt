package com.example.domain.use_cases.person

import com.example.domain.models.person_models_domain.PersonModelsDomain
import com.example.domain.models.person_models_domain.ResultDomain
import com.example.domain.repository.MovieRepository

class FetchPersonActorsMovieImpl(
    private val repository: MovieRepository
) : FetchPersonActorsMovie {
    override suspend fun invoke(page: Int): Result<List<ResultDomain>> {
        return repository.fetchPopularActors(page)
    }
}