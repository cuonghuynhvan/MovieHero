package com.cuong.moviehero.ui.components

import android.Manifest
import android.os.Build
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.util.findActivity
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestLocationPermission(
    showRequest: Boolean = false,
    onAllPermissionGranted: () -> Unit = {},
    onUserDisallowToShowAgain: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    if (!showRequest) {
        return
    }

    val context = LocalContext.current
    val mainActivity = context.findActivity()

    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )

    val userDeniedToShowAgain = !locationPermissionsState.allPermissionsGranted && (
            Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                    !mainActivity.shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION) ||
                    !mainActivity.shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION))
    LaunchedEffect(key1 = userDeniedToShowAgain, block = {
        if (userDeniedToShowAgain) {
            onUserDisallowToShowAgain()
        }
    })

    LaunchedEffect(key1 = locationPermissionsState.allPermissionsGranted, block = {
        if (locationPermissionsState.allPermissionsGranted) {
            onAllPermissionGranted()
        }
    })

    if (!locationPermissionsState.allPermissionsGranted && !userDeniedToShowAgain) {
        val allPermissionsRevoked =
            locationPermissionsState.permissions.size ==
                    locationPermissionsState.revokedPermissions.size

        AlertDialog(
            onDismissRequest = onDismissRequest,
            text = {
                val textToShow = if (!allPermissionsRevoked) {
                    stringResource(id = R.string.message_request_location_revoked)
                } else if (locationPermissionsState.shouldShowRationale) {
                    stringResource(id = R.string.message_request_location_rationale)
                } else {
                    stringResource(id = R.string.error_message_location_permission_denied)
                }
                Text(textToShow)
            },
            confirmButton = {
                Button(
                    onClick = {
                        locationPermissionsState.launchMultiplePermissionRequest()
                        onDismissRequest()
                    }
                ) {
                    Text(stringResource(id = R.string.button_request_permission))
                }
            },
        )
    }
}