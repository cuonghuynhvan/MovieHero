package com.cuong.moviehero.domain.use_case

import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.repository.LocationRepository

class RequestCurrentLocation(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(): GPSPoint {
        return repository.requestCurrentLocation()
    }
}