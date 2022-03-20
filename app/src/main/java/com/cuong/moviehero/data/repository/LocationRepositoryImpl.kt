package com.cuong.moviehero.data.repository

import android.content.Context
import com.cuong.moviehero.data.entity.mapper.PlaceEntityDataMapper
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.repository.LocationRepository
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationRepositoryImpl(
    private val context: Context,
    private val placeEntityDataMapper: PlaceEntityDataMapper,
) : LocationRepository {
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
            throw it
        }
        runTask.addOnCanceledListener {
            cont.resume(emptyList())
        }
    }
}
