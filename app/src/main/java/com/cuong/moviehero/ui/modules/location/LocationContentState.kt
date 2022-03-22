package com.cuong.moviehero.ui.modules.location

import androidx.compose.runtime.Immutable
import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint

@Immutable
data class LocationContentState(
    val centerPoint: GPSPoint = GPSPoint(),
    val centerPointName: String = "",
    val showCenterPointPin: Boolean = false,
    val showDirection: Boolean = false,
    val direction: Direction = Direction(),
)
