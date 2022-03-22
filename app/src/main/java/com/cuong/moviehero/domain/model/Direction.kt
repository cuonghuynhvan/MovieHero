package com.cuong.moviehero.domain.model

data class Direction(
    val steps: List<Step> = emptyList(),
    val northeastPoint: GPSPoint = GPSPoint(),
    val southwestPoint: GPSPoint = GPSPoint(),
)

data class Step(
    val startPoint: GPSPoint,
    val endPoint: GPSPoint,
)