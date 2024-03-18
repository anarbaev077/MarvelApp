package com.example.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MoviesCacheModel::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}