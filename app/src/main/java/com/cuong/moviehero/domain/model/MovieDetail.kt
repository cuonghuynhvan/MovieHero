package com.cuong.moviehero.domain.model

data class MovieDetail(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val backdropImageUrl: String = "",
    val rate: Float = 0f,
    val genres: List<String> = emptyList(),
    val runtime: Int = 0,
)