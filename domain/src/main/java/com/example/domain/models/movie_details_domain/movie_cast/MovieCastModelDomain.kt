package com.example.domain.models.movie_details_domain.movie_cast

import java.io.Serializable

data class MovieCastModelDomain(
    val cast: List<CastDomain>,
    val crew: List<CrewDomain>,
    val id: Int
) : Serializable {
    companion object {
        val unknown = MovieCastModelDomain(
            cast = listOf(),
            crew = listOf(),
            id = 0
        )
    }
}