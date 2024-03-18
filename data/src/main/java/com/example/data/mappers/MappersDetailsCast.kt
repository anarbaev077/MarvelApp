package com.example.data.mappers

import com.example.data.models.movie_details.movie_cast.Cast
import com.example.data.models.movie_details.movie_cast.Crew
import com.example.data.models.movie_details.movie_cast.MovieCastModel
import com.example.data.utils.Constants
import com.example.domain.models.movie_details_domain.movie_cast.CastDomain
import com.example.domain.models.movie_details_domain.movie_cast.CrewDomain
import com.example.domain.models.movie_details_domain.movie_cast.MovieCastModelDomain

fun Cast.toDomainModel() = CastDomain(
    adult = adult,
    castId = castId,
    character = character,
    creditId = creditId,
    gender = gender,
    id = id,
    knownForDepartment = knownForDepartment,
    name = name,
    order = order,
    originalName = originalName,
    popularity = popularity,
    profilePath = "${Constants.POSTER_PATH_URL}${this.profilePath}",
)

fun Crew.toDomainModel() = CrewDomain(
    adult = adult,
    creditId = creditId,
    department = department,
    gender = gender,
    id = id,
    job = job,
    knownForDepartment = knownForDepartment,
    name = name,
    originalName = originalName,
    popularity = popularity,
    profilePath = "${Constants.POSTER_PATH_URL}${this.profilePath}",
)

fun MovieCastModel.toDomainModel() = MovieCastModelDomain(
    crew = crew.map { it.toDomainModel() },
    cast = cast.map { it.toDomainModel() },
    id = id
)