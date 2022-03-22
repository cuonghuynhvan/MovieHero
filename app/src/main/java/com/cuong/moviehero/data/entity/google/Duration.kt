package com.cuong.moviehero.data.entity.google


import com.google.gson.annotations.SerializedName

data class Duration(
    @SerializedName("text")
    val text: String?,
    @SerializedName("value")
    val value: Int?
)