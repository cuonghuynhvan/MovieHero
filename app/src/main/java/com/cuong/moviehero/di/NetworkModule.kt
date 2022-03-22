package com.cuong.moviehero.di

import android.content.Context
import com.cuong.moviehero.data.api.APIBuilder
import com.cuong.moviehero.data.api.GoogleApiService
import com.cuong.moviehero.data.entity.mapper.PlaceEntityDataMapper
import com.cuong.moviehero.data.repository.LocationRepositoryImpl
import com.cuong.moviehero.domain.repository.LocationRepository
import com.cuong.moviehero.domain.use_case.*
import com.cuong.moviehero.ui.modules.common.ExceptionMessageHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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