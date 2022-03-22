package com.cuong.moviehero.di

import android.content.Context
import com.cuong.moviehero.data.api.GoogleApiService
import com.cuong.moviehero.data.entity.mapper.GoogleDirectionEntityDataMapper
import com.cuong.moviehero.data.entity.mapper.PlaceEntityDataMapper
import com.cuong.moviehero.data.repository.LocationRepositoryImpl
import com.cuong.moviehero.domain.repository.LocationRepository
import com.cuong.moviehero.domain.use_case.location.*
import com.cuong.moviehero.ui.modules.common.ExceptionMessageHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideExceptionHandler(): ExceptionMessageHandler {
        return ExceptionMessageHandler()
    }
}