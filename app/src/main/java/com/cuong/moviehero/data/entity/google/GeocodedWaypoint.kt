package com.cuong.moviehero.data.entity.google


import com.google.gson.annotations.SerializedName

data class GeocodedWaypoint(
    @SerializedName("geocoder_status")
    val geocoderStatus: String?,
    @SerializedName("place_id")
    val placeId: String?,
    @SerializedName("types")
    val types: List<String>?
)