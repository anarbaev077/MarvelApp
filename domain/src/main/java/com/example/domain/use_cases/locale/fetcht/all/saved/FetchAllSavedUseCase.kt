package com.example.domain.use_cases.locale.fetcht.all.saved

import com.example.domain.models.movie_list_domain.MovieDomainModel
import kotlinx.coroutines.flow.Flow

interface FetchAllSavedUseCase {
    operator fun invoke(): Flow<List<MovieDomainModel>>
}