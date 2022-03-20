package com.cuong.moviehero.domain.use_case

import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.repository.LocationRepository

class SearchPlaces(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(query: String): List<Place> {
        return repository.searchPlaces(query)
    }
}