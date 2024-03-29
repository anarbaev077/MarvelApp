package com.example.data.models.movie_details

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) : Serializable