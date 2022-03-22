package com.cuong.moviehero.di

import com.cuong.moviehero.data.api.APIBuilder
import com.cuong.moviehero.data.api.GoogleApiService
import com.cuong.moviehero.data.api.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGoogleApiService(): GoogleApiService {
        return APIBuilder.getGoogleInstance().create(GoogleApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApiService {
        return APIBuilder.getMovieInstance().create(MovieApiService::class.java)
    }
}