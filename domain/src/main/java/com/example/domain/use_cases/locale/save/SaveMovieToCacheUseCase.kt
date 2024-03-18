package com.example.domain.use_cases.locale.save

import com.example.domain.models.movie_list_domain.MovieDomainModel

interface SaveMovieToCacheUseCase {

    suspend operator fun invoke(movieModel: MovieDomainModel)

}