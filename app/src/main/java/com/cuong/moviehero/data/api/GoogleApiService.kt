package com.cuong.moviehero.data.api

import com.cuong.moviehero.BuildConfig
import com.cuong.moviehero.data.entity.google.GoogleDirectionEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleApiService {
    @GET("directions/json")
    suspend fun fetchDirection(
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("key") key: String = BuildConfig.GOOGLE_API_KEY,
    ): GoogleDirectionEntity
}