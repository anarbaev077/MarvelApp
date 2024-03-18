package com.example.domain.use_cases.details.cast_detail

import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain

interface FetchCastDetailsMovieUseCase {

    suspend operator fun invoke(movieId: Int): Result<MovieCastModelDomain>
}