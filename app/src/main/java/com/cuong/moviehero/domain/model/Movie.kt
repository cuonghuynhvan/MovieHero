package com.cuong.moviehero.domain.model

data class Movie(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val releaseDate: String = "",
    val imageUrl: String = "",
    val rate: Float = 0f,
)