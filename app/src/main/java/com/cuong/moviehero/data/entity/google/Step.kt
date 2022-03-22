package com.cuong.moviehero.data.entity.google


import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("distance")
    val distance: Distance?,
    @SerializedName("duration")
    val duration: Duration?,
    @SerializedName("end_location")
    val endLocation: Location?,
    @SerializedName("html_instructions")
    val htmlInstructions: String?,
    @SerializedName("maneuver")
    val maneuver: String?,
    @SerializedName("polyline")
    val polyline: Polyline?,
    @SerializedName("start_location")
    val startLocation: Location?,
    @SerializedName("travel_mode")
    val travelMode: String?
)