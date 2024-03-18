package com.example.data.mappers

import com.example.data.models.movie_details.Genre
import com.example.data.models.movie_details.MovieDetailModel
import com.example.data.models.movie_details.ProductionCompany
import com.example.data.models.movie_details.ProductionCountry
import com.example.data.models.movie_details.SpokenLanguage
import com.example.data.utils.Constants
import com.example.domain.models.movie_details_domain.GenreDomain
import com.example.domain.models.movie_details_domain.MovieDetailModelDomain
import com.example.domain.models.movie_details_domain.ProductionCompanyDomain
import com.example.domain.models.movie_details_domain.ProductionCountryDomain
import com.example.domain.models.movie_details_domain.SpokenLanguageDomain
import com.example.domain.models.movie_list_domain.MovieDomainModel

fun Genre.toDomainModel() = GenreDomain(
    name = name,
    id = id
)

fun ProductionCompany.toDomainModel() = ProductionCompanyDomain(
    id = id,
    name = name,
    originCountry = originCountry
)

fun ProductionCountry.toDomainModel() = ProductionCountryDomain(
    name = name
)

fun SpokenLanguage.toDomainModel() = SpokenLanguageDomain(
    englishName = englishName,
    name = name
)

fun MovieDetailModel.toDomainModel() = MovieDetailModelDomain(
    adult = adult,
    backdropPath = "${Constants.POSTER_PATH_URL}${this.backdropPath}",
    budget = budget,
    genres = genres.map { it.toDomainModel() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = "${Constants.POSTER_PATH_URL}${this.posterPath}",
    productionCompanies = productionCompanies.map { it.toDomainModel() },
    productionCountries = productionCountries.map { it.toDomainModel() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toDomainModel() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)