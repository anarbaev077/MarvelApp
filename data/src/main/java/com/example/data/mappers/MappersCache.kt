package com.example.data.mappers

import com.example.data.locale.MoviesCacheModel
import com.example.domain.models.movie_list_domain.MovieDomainModel

fun MovieDomainModel.toCache() = MoviesCacheModel(
    posterPath = posterPath.orEmpty(),
    adult = adult ?: false,
    overview = overview.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    id = id ?: 0,
    originalLanguage = originalLanguage.orEmpty(),
    title = title.orEmpty(),
    originalTitle = originalTitle.orEmpty(),
    backdropPath = backdropPath.orEmpty(),
    popularity = popularity ?: 0.0,
    voteCount = voteCount ?: 0,
    video = video ?: false,
    rating = rating ?: 0.0,
)

fun MoviesCacheModel.toDomain() = MovieDomainModel(
    posterPath = posterPath.orEmpty(),
    adult = adult ?: false,
    overview = overview.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    id = id ?: 0,
    originalLanguage = originalLanguage.orEmpty(),
    title = title.orEmpty(),
    backdropPath = backdropPath.orEmpty(),
    popularity = popularity ?: 0.0,
    voteCount = voteCount ?: 0,
    video = video ?: false,
    rating = rating ?: 0.0,
    genres = emptyList(),
    originalTitle = title,
)