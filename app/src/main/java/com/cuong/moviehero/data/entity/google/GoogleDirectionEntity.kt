package com.cuong.moviehero.data.entity.google


import com.google.gson.annotations.SerializedName

data class GoogleDirectionEntity(
    @SerializedName("geocoded_waypoints")
    val geocodedWaypoints: List<GeocodedWaypoint>?,
    @SerializedName("routes")
    val routes: List<Route>?,
    @SerializedName("status")
    val status: String?
)