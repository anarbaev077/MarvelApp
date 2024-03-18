package com.example.data.locale

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Insert(entity = MoviesCacheModel::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToCache(cacheModel: MoviesCacheModel)

    @Query("SELECT * FROM movies_table_name")
    fun fetchAllMoviesFromCache(): Flow<List<MoviesCacheModel>>

    @Query("DELETE FROM movies_table_name WHERE id = :movieId")
    suspend fun deleteMoviesById(movieId: Int)

    @Query("DELETE FROM movies_table_name")
    suspend fun clearTable()

}