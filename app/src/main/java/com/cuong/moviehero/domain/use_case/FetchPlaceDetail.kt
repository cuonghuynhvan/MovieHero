package com.cuong.moviehero.domain.use_case

import androidx.annotation.WorkerThread
import com.cuong.moviehero.domain.model.PlaceDetail
import com.cuong.moviehero.domain.repository.LocationRepository

class FetchPlaceDetail(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(id: String): PlaceDetail {
        return repository.fetchPlaceDetail(id)
    }
}