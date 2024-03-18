package com.example.domain.models.person_models_domain

import java.io.Serializable


data class ResultDomain(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val popularity: Double,
    val profilePath: String
): Serializable