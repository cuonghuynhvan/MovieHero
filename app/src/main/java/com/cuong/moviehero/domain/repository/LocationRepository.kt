package com.cuong.moviehero.domain.repository

import com.cuong.moviehero.domain.model.Place

interface LocationRepository {
    suspend fun searchPlaces(query: String): List<Place>
}