package com.example.domain.models.movie_details_domain

import java.io.Serializable


data class ProductionCompanyDomain(
    val id: Int,
    val name: String,
    val originCountry: String
) : Serializable{
    companion object {
        val unknown = ProductionCompanyDomain(
            id = 0,
            name = "",
            originCountry = ""
        )
    }
}