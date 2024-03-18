package com.example.data.models.movie_details

import com.google.gson.annotations.SerializedName


data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("name")
    val name: String
)