package com.example.data.locale.data.source

import com.example.data.locale.MoviesCacheModel
import kotlinx.coroutines.flow.Flow

interface MovieCacheDataSource {

    suspend fun addMoviesToCache(cacheModel: MoviesCacheModel)

    fun fetchAllCachedMovies(): Flow<List<MoviesCacheModel>>

    suspend fun deleteMovieById(movieId: Int)

    suspend fun clearTable()

    suspend fun getMovieById(movieId: Int): MoviesCacheModel

}