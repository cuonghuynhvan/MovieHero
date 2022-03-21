package com.cuong.moviehero.domain.repository

import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Place

interface LocationRepository {
    suspend fun searchPlaces(query: String): List<Place>
    suspend fun requestCurrentLocation(): GPSPoint
    fun stopLocationUpdate()
}