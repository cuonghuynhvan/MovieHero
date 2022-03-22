package com.cuong.moviehero.data.repository

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Looper
import androidx.core.content.ContextCompat
import com.cuong.moviehero.data.api.GoogleApiService
import com.cuong.moviehero.data.entity.mapper.GoogleDirectionEntityDataMapper
import com.cuong.moviehero.data.entity.mapper.PlaceEntityDataMapper
import com.cuong.moviehero.domain.exception.*
import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.model.PlaceDetail
import com.cuong.moviehero.domain.repository.LocationRepository
import com.google.android.gms.location.*
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class LocationRepositoryImpl(
    private val context: Context,
    private val googleApiService: GoogleApiService,
    private val placeEntityDataMapper: PlaceEntityDataMapper,
    private val googleDirectionEntityDataMapper: GoogleDirectionEntityDataMapper,
) : LocationRepository {
    private var fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)
    private var locationCallback: LocationCallback? = null

    override suspend fun searchPlaces(query: String): List<Place> = suspendCoroutine { cont ->
        val placesClient = Places.createClient(context)
        val autoCompleteParam = FindAutocompletePredictionsRequest.builder()
            .setQuery(query)
            .build()
        val runTask = placesClient.findAutocompletePredictions(autoCompleteParam)
        runTask.addOnSuccessListener {
            cont.resume(placeEntityDataMapper.transform(it.autocompletePredictions))
        }
        runTask.addOnFailureListener {
            cont.resumeWithException(NetworkConnectionException("connection error"))
        }
        runTask.addOnCanceledListener {
            cont.resume(emptyList())
        }
    }

    @SuppressLint("MissingPermission")
    override suspend fun requestCurrentLocation(): GPSPoint = suspendCoroutine { cont ->
        if (
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED ||
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            throw NeedRequestLocationPermissionException("require location permission")
        }

        if(!isLocationEnable()) {
            throw GetLocationFailedException("cannot get location")
        }

        stopLocationUpdate()

        val locationRequest = LocationRequest()

        val callback = object : LocationCallback() {
            override fun onLocationAvailability(locationAvailability: LocationAvailability?) {
                super.onLocationAvailability(locationAvailability)

                if (locationAvailability?.isLocationAvailable != true) {
                    stopLocationUpdate()
                    cont.resumeWithException(GetLocationFailedException("cannot get location"))
                }
            }

            override fun onLocationResult(result: LocationResult?) {
                super.onLocationResult(result)

                stopLocationUpdate()
                if (result == null) {
                    cont.resumeWithException(GetLocationFailedException("cannot get location"))
                } else {
                    cont.resume(
                        GPSPoint(
                            lat = result.lastLocation.latitude,
                            lng = result.lastLocation.longitude
                        )
                    )
                }
            }
        }

        locationCallback = callback
        fusedLocationClient.requestLocationUpdates(locationRequest, callback, Looper.getMainLooper())
    }

    private fun isLocationEnable(): Boolean {
        val lm: LocationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gpsEnabled = false
        var networkEnabled = false

        try {
            gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
        }

        try {
            networkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (ex: Exception) { }

        return gpsEnabled || networkEnabled
    }

    override fun stopLocationUpdate() {
        locationCallback?.let {
            fusedLocationClient.removeLocationUpdates(it)
        }
        locationCallback = null
    }

    override suspend fun fetchPlaceDetail(id: String): PlaceDetail = suspendCoroutine { cont ->
        val placesClient = Places.createClient(context)

        val placeFields: List<com.google.android.libraries.places.api.model.Place.Field> = listOf(
            com.google.android.libraries.places.api.model.Place.Field.ID,
            com.google.android.libraries.places.api.model.Place.Field.NAME,
            com.google.android.libraries.places.api.model.Place.Field.LAT_LNG,
            com.google.android.libraries.places.api.model.Place.Field.ADDRESS
        )
        val request = FetchPlaceRequest.builder(id, placeFields).build()
        val runTask = placesClient.fetchPlace(request)
        runTask.addOnSuccessListener {
            cont.resume(placeEntityDataMapper.transform(it.place))
        }
        runTask.addOnFailureListener {
            cont.resumeWithException(NetworkConnectionException("connection error"))
        }
        runTask.addOnCanceledListener {
            cont.resumeWithException(FetchPlaceDetailFailedException("cannot get place detail"))
        }
    }

    override suspend fun fetchDirectionFromLocationToPlace(
        location: GPSPoint,
        placeId: String
    ): Direction {
        try {
            val result = googleApiService.fetchDirection(location.toString(), "place_id:${placeId}")
            val direction = googleDirectionEntityDataMapper.transform(result)
            return direction ?: throw FetchGoogleDirectionFailedException("invalid data")
        } catch (e: HttpException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: SocketTimeoutException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: UnknownHostException) {
            throw NetworkConnectionException("internet connection issue")
        }
    }
}
