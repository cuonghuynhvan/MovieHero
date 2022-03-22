package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.*

@Composable
fun GoogleMapWrapper(
    modifier: Modifier = Modifier,
    centerPoint: GPSPoint = GPSPoint(),
    centerPointName: String = "",
    showCenterPointPin: Boolean = false,
    showDirection: Boolean = false,
    direction: Direction = Direction(),
) {
    val cameraPositionState = rememberCameraPositionState {
        val centerLocation = LatLng(centerPoint.lat, centerPoint.lng)
        position = CameraPosition.fromLatLngZoom(centerLocation, 15f)
    }
    val uiSettings by remember {
        val settings = MapUiSettings(
            zoomControlsEnabled = false
        )
        mutableStateOf(settings)
    }

    LaunchedEffect(key1 = centerPoint, block = {
        val centerLocation = LatLng(centerPoint.lat, centerPoint.lng)
        cameraPositionState.animate(CameraUpdateFactory.newLatLngZoom(centerLocation, 15f))
    })

    LaunchedEffect(key1 = showDirection, key2 = direction, block = {
        if(!showDirection || direction.steps.isEmpty()) {
            return@LaunchedEffect
        }

        val latLngBounds = LatLngBounds(
            LatLng( direction.southwestPoint.lat, direction.southwestPoint.lng ),
            LatLng( direction.northeastPoint.lat, direction.northeastPoint.lng )
        )
        cameraPositionState.animate(
            CameraUpdateFactory.newLatLngBounds(latLngBounds, 100)
        )
    })

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings
    ) {
        if(showDirection) {
            Polyline(
                points = direction.steps.mapIndexed { index, step ->
                    if (index == 0) {
                        LatLng(step.startPoint.lat, step.startPoint.lng)
                    } else {
                        LatLng(step.endPoint.lat, step.endPoint.lng)
                    }
                },
                color = MaterialTheme.colors.primary,
            )
        }

        if(showCenterPointPin) {
            val centerLocation = LatLng(centerPoint.lat, centerPoint.lng)
            Marker(
                position = centerLocation,
                title = centerPointName,
            )
        }
    }
}