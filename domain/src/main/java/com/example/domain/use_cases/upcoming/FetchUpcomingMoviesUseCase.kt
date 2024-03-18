package com.example.domain.use_cases.upcoming

import com.example.domain.models.movie_list_domain.MovieDomainModel

interface FetchUpcomingMoviesUseCase {

    suspend operator fun invoke(page:Int):Result<List<MovieDomainModel>>

}