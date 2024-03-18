package com.example.domain.models.person_models_domain

import java.io.Serializable


data class PersonModelsDomain(
    val page: Int,
    val results: List<ResultDomain>,
    val totalPages: Int,
    val totalResults: Int
) : Serializable {
    companion object {
        val unknown = PersonModelsDomain(
            page = 0,
            results = listOf(),
            totalPages = 0,
            totalResults = 0
        )
    }
}