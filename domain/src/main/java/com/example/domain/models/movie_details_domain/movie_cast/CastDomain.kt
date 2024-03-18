package com.example.domain.models.movie_details_domain.movie_cast

import java.io.Serializable


data class CastDomain(
    val adult: Boolean,
    val castId: Int,
    val character: String,
    val creditId: String,
    val gender: Int,
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val order: Int,
    val originalName: String,
    val popularity: Double,
    val profilePath: String
) : Serializable {
    companion object {
        val unknown = CastDomain(
            adult = false,
            castId = 0,
            character = "",
            creditId ="",
            gender = 0,
            id = 0,
            knownForDepartment = "",
            name = "",
            order = 0,
            originalName = "",
            popularity = 0.0,
            profilePath = "",
        )
    }
}