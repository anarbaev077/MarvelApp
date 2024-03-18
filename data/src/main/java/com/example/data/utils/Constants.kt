package com.example.data.utils

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "3249dba9ba8a81c53f42a124fe89e8e5"
    const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/original/"
    const val LANGUAGE_RU = "ru"
    const val API = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MTExYzhlZjZkM2NlYWVmYjU3N2I3NmUzZWZjMjY4MCIsInN1YiI6IjY1YmNkZTI5Y2ZmZWVkMDE3Y2FmYmRjNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dH9lUXh9oxnd6gB8pGn9hsq4_hUE7dLUWauehXZi4hg"
    const val LANGUAGE_EN = "en"
    const val YOUTUBE_URL = "https://www.youtube.com/watch?v="

    object Movie {
        const val POPULAR = "movie/popular"
        const val TOP_RATED = "movie/top_rated"
        const val UPCOMING = "movie/upcoming"
        const val NOW_PLAYING = "movie/now_playing"
        const val SEARCH_MOVIE = "search/movie"
        const val MOVIE_DETAILS = "movie/{movie_id}"
        const val SIMILAR = "movie/{movie_id}/similar"
        const val RECOMMENDATIONS = "movie/{movie_id}/recommendations"
        const val RATE_MOVIE = "movie/{movie_id}/rating"
        const val DELETE_RATE = "movie/{movie_id}/rating"
        const val CAST_FOR_DETAIL_SCREEN = "movie/{movie_id}/credits"
    }

    object TVSerials {
        const val TRENDING_TV = "trending/tv/day"
        const val TOP_RATED_TV = "tv/top_rated"
        const val ON_THE_AIR_TV = "tv/on_the_air"
        const val POPULAR_TV = "tv/popular"
        const val AIRING_TODAY_TV = "tv/airing_today"
    }

    object TRAILER {
        const val MOVIE_TRAILERS = "movie/{movie_id}/videos"
    }

    object Person {
        const val SEARCH_PEOPLE = "search/person"
        const val PERSON_POPULAR = "person/popular"
        const val PERSON_DETAILS = "person/{person_id}"
    }

}