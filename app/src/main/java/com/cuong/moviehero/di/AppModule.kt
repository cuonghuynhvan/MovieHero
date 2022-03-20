package com.cuong.moviehero.di

import android.content.Context
import com.cuong.moviehero.data.entity.mapper.PlaceEntityDataMapper
import com.cuong.moviehero.data.repository.LocationRepositoryImpl
import com.cuong.moviehero.domain.repository.LocationRepository
import com.cuong.moviehero.domain.use_case.LocationUseCases
import com.cuong.moviehero.domain.use_case.SearchPlaces
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
    fun provideLocationRepository(@ApplicationContext context: Context, mapper: PlaceEntityDataMapper): LocationRepository {
        return LocationRepositoryImpl(context, mapper)
    }

    @Provides
    @Singleton
    fun provideLocationUseCases(repository: LocationRepository): LocationUseCases {
        return LocationUseCases(
            searchPlaces = SearchPlaces(repository),
        )
    }
}