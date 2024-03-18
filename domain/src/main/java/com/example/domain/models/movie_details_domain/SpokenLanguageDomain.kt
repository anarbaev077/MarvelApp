package com.example.domain.models.movie_details_domain

import java.io.Serializable


data class SpokenLanguageDomain(
    val englishName: String,
    val name: String
):Serializable{
    companion object {
        val unknown = SpokenLanguageDomain(
            englishName = "",
            name = ""
        )
    }
}