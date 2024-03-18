package com.example.domain.models.movie_details_domain.movie_cast

import java.io.Serializable

data class CrewDomain(
    val adult: Boolean,
    val creditId: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val popularity: Double,
    val profilePath: String
) : Serializable