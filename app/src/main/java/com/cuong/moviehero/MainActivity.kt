package com.cuong.moviehero

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.cuong.moviehero.domain.exception.GetLocationFailedException
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.ui.MovieHeroApp
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import com.google.android.gms.location.*
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent { MovieHeroApp() }
    }

    override fun onResume() {
        super.onResume()
        startLocationUpdates()
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val locationRequest = LocationRequest()
//        locationRequest.numUpdates = 1
//        locationRequest.expirationTime = 5000L
//        locationRequest.maxWaitTime = 5000L

//        val callback = object : LocationCallback() {
//            override fun onLocationAvailability(locationAvailability: LocationAvailability?) {
//                super.onLocationAvailability(locationAvailability)
//
//            }
//
//            override fun onLocationResult(result: LocationResult?) {
//                super.onLocationResult(result)
//            }
//        }
//
//        fusedLocationClient.requestLocationUpdates(locationRequest, callback, Looper.getMainLooper())
    }
}
