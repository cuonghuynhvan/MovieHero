package com.cuong.moviehero.domain.use_case.location

import com.cuong.moviehero.domain.repository.LocationRepository

class StopLocationUpdate(
    private val repository: LocationRepository
) {
    operator fun invoke() {
        return repository.stopLocationUpdate()
    }
}