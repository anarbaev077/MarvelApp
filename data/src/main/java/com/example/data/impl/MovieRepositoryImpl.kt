package com.example.data.repository.impl

import com.example.data.locale.data.source.MovieCacheDataSource
import com.example.data.mappers.toCache
import com.example.data.mappers.toDomain
import com.example.data.mappers.toDomainModel
import com.example.data.models.movie_list.MovieResponseCloudModel
import com.example.data.models.person_models.PersonModels
import com.example.data.remote.MovieService
import com.example.data.utils.Constants.API
import com.example.data.utils.Constants.API_KEY
import com.example.domain.models.movie_details_domain.MovieDetailModelDomain
import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.domain.models.person_models_domain.ResultDomain
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override fun fetchAllSavedMovies(): Flow<List<MovieDomainModel>> {
        return movieCacheDataSource.fetchAllCachedMovies()
            .map { it.map { it.toDomain() } }
    }

    override suspend fun saveMoviesToCache(movieModel: MovieDomainModel) {
        movieCacheDataSource.addMoviesToCache(cacheModel = movieModel.toCache())
    }

    override suspend fun fetchCastDetailMovie(movieId: Int): Result<MovieCastModelDomain> {
        return try {
            val response = service.getCastForDetail(movieId)
            if (response.isSuccessful) {
                val movieCastDetail = response.body()?.toDomainModel()
                    ?: throw NullPointerException("Movie details are null")
                Result.success(movieCastDetail)
            } else {
                Result.failure(Throwable("Failed to fetch movie details"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun fetchTopRatedMovie(page: Int): Result<List<MovieDomainModel>> =
        sendRequestService(model = service.getTopRatedMovies(page = page))


    override suspend fun fetchPopularMovie(
        page: Int
    ): Result<List<MovieDomainModel>> =
        sendRequestService(model = service.getPopularMovies(page = page))

    override suspend fun fetchUpcomingMovie(
        page: Int
    ): Result<List<MovieDomainModel>> =
        sendRequestService(model = service.getUpcomingMovies(page = page))

    override suspend fun fetchNowPlayingMovie(
        page: Int
    ): Result<List<MovieDomainModel>> =
        sendRequestService(model = service.getNowPlayingMovies(page = page))

    override suspend fun fetchDetailMovie(movieId: Int): Result<MovieDetailModelDomain> {
        return try {
            val response = service.getMovieDetails(movieId)
            if (response.isSuccessful) {
                val movieDetail = response.body()?.toDomainModel()
                    ?: throw NullPointerException("Movie details are null")
                Result.success(movieDetail)
            } else {
                Result.failure(Throwable("Failed to fetch movie details"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun fetchPopularActors(page: Int): Result<List<ResultDomain>> =
        sendRequestServicePerson(service.getPopularPerson(page = page))

    override suspend fun searchMovies(movieTitle: String): Result<List<MovieDomainModel>> =
         sendRequestService(service.searchMoviesByQuery(movieTitle = movieTitle, apiKey = "Bearer $API" ))


    private fun sendRequestServicePerson(model: Response<PersonModels>): Result<List<ResultDomain>> {
        return try {
            if (model.isSuccessful) {
                return Result.success(
                    model.body()?.results?.map {
                        it.toDomainModel()
                    }.orEmpty()
                )
            } else Result.failure(Throwable())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }

    private fun sendRequestService(model: Response<MovieResponseCloudModel>): Result<List<MovieDomainModel>> {
        return try {
            if (model.isSuccessful) {
                return Result.success(
                    model.body()?.movies?.map {
                        it.toDomainModel()
                    }.orEmpty()
                )
            } else Result.failure(Throwable())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }
}
