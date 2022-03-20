package com.cuong.moviehero.data.entity.mapper

import com.cuong.moviehero.domain.model.Place
import com.google.android.libraries.places.api.model.AutocompletePrediction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceEntityDataMapper @Inject constructor() {
    fun transform(data: List<AutocompletePrediction>) : List<Place> {
        return data.map {
            Place(
                placeId = it.placeId,
                name = it.getPrimaryText(null).toString(),
                address = it.getSecondaryText(null).toString(),
            )
        }
    }
}