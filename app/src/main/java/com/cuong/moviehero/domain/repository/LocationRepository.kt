package com.cuong.moviehero.domain.repository

import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.model.PlaceDetail

interface LocationRepository {
    
    suspend fun searchPlaces(query: String): List<Place>

    suspend fun requestCurrentLocation(): GPSPoint

    fun stopLocationUpdate()

    suspend fun fetchPlaceDetail(id: String): PlaceDetail

    suspend fun fetchDirectionFromLocationToPlace(location: GPSPoint, placeId: String): Direction
}