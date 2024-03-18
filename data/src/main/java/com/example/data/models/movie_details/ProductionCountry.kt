package com.example.data.models.movie_details


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCountry(
    @SerializedName("name")
    val name: String
) : Serializable