package com.cuong.moviehero.di

import com.cuong.moviehero.data.api.MovieApiService
import com.cuong.moviehero.data.entity.mapper.MovieEntityDataMapper
import com.cuong.moviehero.data.repository.MovieRepositoryImpl
import com.cuong.moviehero.domain.repository.MovieRepository
import com.cuong.moviehero.domain.use_case.movie.FetchMovieDetail
import com.cuong.moviehero.domain.use_case.movie.FetchNowPlaying
import com.cuong.moviehero.domain.use_case.movie.FetchTopRated
import com.cuong.moviehero.domain.use_case.movie.MovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApiService: MovieApiService,
        movieEntityDataMapper: MovieEntityDataMapper,
    ): MovieRepository {
        return MovieRepositoryImpl(movieApiService, movieEntityDataMapper)
    }

    @Provides
    @Singleton
    fun provideMovieUseCases(repository: MovieRepository): MovieUseCases {
        return MovieUseCases(
            fetchNowPlaying = FetchNowPlaying(repository),
            fetchTopRated = FetchTopRated(repository),
            fetchMovieDetail = FetchMovieDetail(repository),
        )
    }
}