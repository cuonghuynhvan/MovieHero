package com.cuong.moviehero.data.entity.mapper

import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.model.PlaceDetail
import com.google.android.libraries.places.api.model.AutocompletePrediction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceEntityDataMapper @Inject constructor() {
    fun transform(data: List<AutocompletePrediction>) : List<Place> {
        return data.map {
            Place(
                id = it.placeId,
                name = it.getPrimaryText(null).toString(),
                address = it.getSecondaryText(null).toString(),
            )
        }
    }

    fun transform(place: com.google.android.libraries.places.api.model.Place) : PlaceDetail {
        return PlaceDetail(
            id = place.id ?: "",
            name = place.name ?: "",
            address = place.address ?: "",
            gpsPoint = GPSPoint(
                lat = place.latLng?.latitude ?: 0.0,
                lng = place.latLng?.longitude ?: 0.0,
            )
        )
    }
}