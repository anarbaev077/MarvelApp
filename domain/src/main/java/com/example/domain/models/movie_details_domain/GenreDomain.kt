package com.example.domain.models.movie_details_domain

import java.io.Serializable

data class GenreDomain(
    val id: Int,
    val name: String
) : Serializable {
    companion object {
        val unknown = GenreDomain(
            id = 0,
            name = ""
        )
    }
}