package com.cuong.moviehero.di

import com.cuong.moviehero.data.api.APIBuilder
import com.cuong.moviehero.data.api.GoogleApiService
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
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GoogleApi

    @GoogleApi
    @Provides
    @Singleton
    fun provideGoogleApiRetrofit(): Retrofit {
        return APIBuilder.getGoogleInstance()
    }

    @Provides
    @Singleton
    fun provideGoogleApiService(@GoogleApi retrofit: Retrofit): GoogleApiService {
        return retrofit.create(GoogleApiService::class.java)
    }
}