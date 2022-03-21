package com.cuong.moviehero.domain.model

import androidx.compose.runtime.Immutable
import java.util.*

@Immutable
data class GPSPoint(
    val lat: Double = 0.0,
    val lng: Double = 0.0,
    val createTime: Long = Date().time,
)