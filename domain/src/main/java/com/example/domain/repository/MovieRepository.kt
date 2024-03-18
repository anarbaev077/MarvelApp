package com.example.domain.repository

import com.example.domain.models.movie_details_domain.MovieDetailModelDomain
import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.models.person_models_domain.ResultDomain
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun fetchAllSavedMovies(): Flow<List<MovieDomainModel>>

    suspend fun saveMoviesToCache(movieModel: MovieDomainModel)

    suspend fun fetchCastDetailMovie(
        movieId: Int
    ): Result<MovieCastModelDomain>

    suspend fun fetchTopRatedMovie(
        page: Int
    ): Result<List<MovieDomainModel>>

    suspend fun fetchPopularMovie(
        page: Int
    ): Result<List<MovieDomainModel>>

    suspend fun fetchUpcomingMovie(
        page: Int
    ): Result<List<MovieDomainModel>>

    suspend fun fetchNowPlayingMovie(
        page: Int
    ): Result<List<MovieDomainModel>>

    suspend fun fetchDetailMovie(
        movieId: Int
    ): Result<MovieDetailModelDomain>

    suspend fun fetchPopularActors(
        page: Int
    ): Result<List<ResultDomain>>

    suspend fun searchMovies(
        movieTitle:String
    ): Result<List<MovieDomainModel>>

}