package com.example.data.remote

import com.example.data.models.movie_details.MovieDetailModel
import com.example.data.models.movie_details.movie_cast.MovieCastModel
import com.example.data.models.movie_list.MovieResponseCloudModel
import com.example.data.models.person_models.PersonModels
import com.example.data.utils.Constants.API_KEY
import com.example.data.utils.Constants.LANGUAGE_EN
import com.example.data.utils.Constants.LANGUAGE_RU
import com.example.data.utils.Constants.Movie.CAST_FOR_DETAIL_SCREEN
import com.example.data.utils.Constants.Movie.MOVIE_DETAILS
import com.example.data.utils.Constants.Movie.NOW_PLAYING
import com.example.data.utils.Constants.Movie.POPULAR
import com.example.data.utils.Constants.Movie.RECOMMENDATIONS
import com.example.data.utils.Constants.Movie.SEARCH_MOVIE
import com.example.data.utils.Constants.Movie.SIMILAR
import com.example.data.utils.Constants.Movie.TOP_RATED
import com.example.data.utils.Constants.Movie.UPCOMING
import com.example.data.utils.Constants.Person.PERSON_POPULAR
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(POPULAR)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int,
        @Query("language") lang: String = LANGUAGE_EN,
    ): Response<MovieResponseCloudModel>

    @GET(TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_EN,
        @Query("page") page: Int,
    ): Response<MovieResponseCloudModel>

    @GET(UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_EN,
        @Query("page") page: Int?,
    ): Response<MovieResponseCloudModel>

    @GET(NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_EN,
        @Query("page") page: Int?,
    ): Response<MovieResponseCloudModel>

    @GET(MOVIE_DETAILS)
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_EN,
        @Query("page") page: Int? = 1,
    ): Response<MovieDetailModel>

    @GET(CAST_FOR_DETAIL_SCREEN)
    suspend fun getCastForDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_EN,
    ): Response<MovieCastModel>

    @GET(PERSON_POPULAR)
    suspend fun getPopularPerson(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_EN,
        @Query("page") page: Int?,
    ): Response<PersonModels>

    @GET(SEARCH_MOVIE)
    suspend fun searchMoviesByQuery(
        @Header("Authorization") apiKey: String,
        @Query("query") movieTitle:String,
    ): Response<MovieResponseCloudModel>
}