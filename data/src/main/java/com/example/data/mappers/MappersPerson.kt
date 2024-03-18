package com.example.data.mappers

import com.example.data.models.person_models.PersonModels
import com.example.data.models.person_models.Result
import com.example.data.utils.Constants
import com.example.domain.models.person_models_domain.PersonModelsDomain
import com.example.domain.models.person_models_domain.ResultDomain

fun Result.toDomainModel() = ResultDomain(
    adult = adult,
    gender = gender,
    id = id,
    knownForDepartment = knownForDepartment,
    name = name,
    originalName = originalName,
    popularity = popularity,
    profilePath = "${Constants.POSTER_PATH_URL}${this.profilePath}",
)

fun PersonModels.toDomainModel() = PersonModelsDomain(
    results = results.map { it.toDomainModel() },
    page = page,
    totalPages = totalPages,
    totalResults = totalResults
)