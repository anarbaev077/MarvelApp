package com.example.domain.models.movie_details_domain

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


data class MovieDetailModelDomain(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<GenreDomain>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDomain>,
    val productionCountries: List<ProductionCountryDomain>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDomain>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Serializable, Parcelable {
    companion object {
        val unknown = MovieDetailModelDomain(
            adult = false,
            backdropPath = "",
            budget = 0,
            genres = listOf(GenreDomain.unknown),
            homepage = "",
            id = 0,
            imdbId = "",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            productionCompanies = listOf(ProductionCompanyDomain.unknown),
            productionCountries = listOf(ProductionCountryDomain.unknown),
            releaseDate = "",
            revenue = 0,
            runtime = 0,
            spokenLanguages = listOf(SpokenLanguageDomain.unknown),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
        )
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}