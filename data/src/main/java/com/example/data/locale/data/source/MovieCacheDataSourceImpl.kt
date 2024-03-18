package com.example.data.locale.data.source

import android.content.Context
import com.example.data.locale.MoviesCacheModel
import com.example.data.locale.MoviesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieCacheDataSourceImpl @Inject constructor(
    private val moviesDao: MoviesDao
): MovieCacheDataSource {

    override suspend fun addMoviesToCache(cacheModel: MoviesCacheModel) {
        moviesDao.addMovieToCache(cacheModel)
    }

    override fun fetchAllCachedMovies(): Flow<List<MoviesCacheModel>> {
        return moviesDao.fetchAllMoviesFromCache()
    }

    override suspend fun deleteMovieById(movieId: Int) {
        moviesDao.deleteMoviesById(movieId)
    }

    override suspend fun clearTable() {
        moviesDao.clearTable()
    }

    override suspend fun getMovieById(movieId: Int): MoviesCacheModel {
        TODO()
    }
}