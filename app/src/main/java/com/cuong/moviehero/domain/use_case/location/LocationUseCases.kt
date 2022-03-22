package com.cuong.moviehero.domain.use_case.location

data class LocationUseCases (
    val searchPlaces: SearchPlaces,
    val requestCurrentLocation: RequestCurrentLocation,
    val stopLocationUpdate: StopLocationUpdate,
    val fetchPlaceDetail: FetchPlaceDetail,
    val fetchDirectionFromLocationToPlace: FetchDirectionFromLocationToPlace,
)