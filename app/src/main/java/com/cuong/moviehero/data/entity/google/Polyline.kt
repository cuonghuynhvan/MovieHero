package com.cuong.moviehero.data.entity.google


import com.google.gson.annotations.SerializedName

data class Polyline(
    @SerializedName("points")
    val points: String?
)