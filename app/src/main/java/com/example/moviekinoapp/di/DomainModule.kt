package com.example.moviekinoapp.di

import com.example.domain.repository.MovieRepository
import com.example.domain.use_cases.details.FetchDetailMovieUseCase
import com.example.domain.use_cases.details.FetchDetailMovieUseCaseImpl
import com.example.domain.use_cases.details.cast_detail.FetchCastDetailsMovieUseCase
import com.example.domain.use_cases.details.cast_detail.FetchCastDetailsMovieUseCaseImpl
import com.example.domain.use_cases.locale.fetcht.all.saved.FetchAllSavedUseCase
import com.example.domain.use_cases.locale.fetcht.all.saved.FetchAllSavedUseCaseImpl
import com.example.domain.use_cases.locale.save.SaveMovieToCacheUseCase
import com.example.domain.use_cases.locale.save.SaveMovieToCacheUseCaseImpl
import com.example.domain.use_cases.now_playing.FetchNowPlayingMovieUseCase
import com.example.domain.use_cases.now_playing.FetchNowPlayingMovieUseCaseImpl
import com.example.domain.use_cases.person.FetchPersonActorsMovie
import com.example.domain.use_cases.person.FetchPersonActorsMovieImpl
import com.example.domain.use_cases.popular.FetchPopularMovieUseCase
import com.example.domain.use_cases.popular.FetchPopularMovieUseCaseImpl
import com.example.domain.use_cases.search.FetchSearchMovieByQueryUseCase
import com.example.domain.use_cases.search.FetchSearchMovieByQueryUseCaseImpl
import com.example.domain.use_cases.top_rated.FetchTopRatedMovieUseCase
import com.example.domain.use_cases.top_rated.FetchTopRatedMovieUseCaseImpl
import com.example.domain.use_cases.upcoming.FetchUpcomingMoviesUseCase
import com.example.domain.use_cases.upcoming.FetchUpcomingMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesFetchPopularMovieUseCase(
        repository: MovieRepository
    ): FetchPopularMovieUseCase = FetchPopularMovieUseCaseImpl(repository)

    @Provides
    fun providesFetchNowPlayingMovieUseCase(
        repository: MovieRepository
    ): FetchNowPlayingMovieUseCase = FetchNowPlayingMovieUseCaseImpl(repository)

    @Provides
    fun providesFetchDetailsMovieUseCase(
        repository: MovieRepository
    ): FetchDetailMovieUseCase = FetchDetailMovieUseCaseImpl(repository)

    @Provides
    fun providesFetchCastMovieDetailUseCase(
        repository: MovieRepository
    ): FetchCastDetailsMovieUseCase = FetchCastDetailsMovieUseCaseImpl(repository)

    @Provides
    fun providesFetchPopularActorsUseCase(
        repository: MovieRepository
    ): FetchPersonActorsMovie = FetchPersonActorsMovieImpl(repository)

    @Provides
    fun providesFetchTopRatedMovieUseCase(
        repository: MovieRepository
    ): FetchTopRatedMovieUseCase = FetchTopRatedMovieUseCaseImpl(repository)

    @Provides
    fun providesFetchUpcomingMoviesUseCaseI(
        repository: MovieRepository
    ): FetchUpcomingMoviesUseCase = FetchUpcomingMoviesUseCaseImpl(repository)

    @Provides
    fun provideSaveMovieToCacheUseCase(
        repository: MovieRepository
    ): SaveMovieToCacheUseCase = SaveMovieToCacheUseCaseImpl(
        repository
    )

    @Provides
    fun providesFetchAllSavedMovies(
        repository: MovieRepository
    ): FetchAllSavedUseCase = FetchAllSavedUseCaseImpl(repository)

    @Provides
    fun providesFetchSearchMovies(
        repository: MovieRepository
    ): FetchSearchMovieByQueryUseCase = FetchSearchMovieByQueryUseCaseImpl(repository)
}