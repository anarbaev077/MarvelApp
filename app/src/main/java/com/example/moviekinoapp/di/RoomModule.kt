package com.example.moviekinoapp.di

import android.content.Context
import androidx.room.Room
import com.example.data.locale.MovieDatabase
import com.example.data.locale.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun providesMovieDao(
        movieDatabase: MovieDatabase
    ):MoviesDao = movieDatabase.moviesDao()

    @Singleton
    @Provides
    fun providesRoomDatabase(
        @ApplicationContext context: Context
    ): MovieDatabase = Room.databaseBuilder(
        context = context,
        MovieDatabase::class.java,
        "movie_database"
    ).build()

}