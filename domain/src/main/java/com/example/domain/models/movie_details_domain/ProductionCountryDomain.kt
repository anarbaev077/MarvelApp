package com.example.domain.models.movie_details_domain


import java.io.Serializable

data class ProductionCountryDomain(
    val name: String
) : Serializable {
    companion object {
        val unknown = ProductionCountryDomain(
            name = ""
        )
    }
}