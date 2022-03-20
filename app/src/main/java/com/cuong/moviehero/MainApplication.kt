package com.cuong.moviehero

import android.app.Application
import com.google.android.libraries.places.api.Places
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize the SDK
        Places.initialize(applicationContext, "AIzaSyDYfto13GBPZ4SD51Fks0EZwWXQctgLvHI")
    }
}