package com.cuong.moviehero.domain.use_case

import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.repository.LocationRepository

class FetchDirectionFromLocationToPlace(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(location: GPSPoint, placeId: String): Direction {
        return repository.fetchDirectionFromLocationToPlace(location, placeId)
    }
}