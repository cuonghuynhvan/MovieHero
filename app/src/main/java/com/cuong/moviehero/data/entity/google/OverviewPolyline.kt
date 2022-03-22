package com.cuong.moviehero.data.entity.google


import com.google.gson.annotations.SerializedName

data class OverviewPolyline(
    @SerializedName("points")
    val points: String?
)