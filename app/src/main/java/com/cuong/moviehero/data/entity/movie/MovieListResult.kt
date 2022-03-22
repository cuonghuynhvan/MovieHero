package com.cuong.moviehero.data.entity.movie


import com.google.gson.annotations.SerializedName

data class MovieListResult(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieEntity>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)