package com.cuong.moviehero.ui.modules.location

import androidx.compose.runtime.Immutable
import com.cuong.moviehero.domain.model.GPSPoint

@Immutable
data class LocationContentState(
    val currentLocation: GPSPoint = GPSPoint(),
)
