package com.example.data.models.movie_details.movie_cast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieCastModel(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
) : Serializable