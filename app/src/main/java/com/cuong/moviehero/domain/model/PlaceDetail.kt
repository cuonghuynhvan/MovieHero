package com.cuong.moviehero.domain.model

data class PlaceDetail(
    val id: String,
    val name: String,
    val address: String,
    val gpsPoint: GPSPoint,
)