package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.use_case.RequestCurrentLocation
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun GoogleMapWrapper(
    modifier: Modifier = Modifier,
    currentLocation: GPSPoint = GPSPoint(),
) {
    val cameraPositionState = rememberCameraPositionState {
        val centerLocation = LatLng(currentLocation.lat, currentLocation.lng)
        position = CameraPosition.fromLatLngZoom(centerLocation, 15f)
    }
    val uiSettings by remember {
        val settings = MapUiSettings(
            zoomControlsEnabled = false
        )
        mutableStateOf(settings)
    }

    LaunchedEffect(key1 = currentLocation, block = {
        val centerLocation = LatLng(currentLocation.lat, currentLocation.lng)
        cameraPositionState.position = CameraPosition.fromLatLngZoom(centerLocation, 15f)
    })

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings
    ) {
//        val centerLocation = LatLng(currentLocation.lat, currentLocation.lng)
//        Marker(position = centerLocation)
    }
}