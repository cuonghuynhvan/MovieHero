package com.cuong.moviehero.data.entity.mapper

import com.cuong.moviehero.BuildConfig
import com.cuong.moviehero.data.entity.movie.MovieDetailEntity
import com.cuong.moviehero.data.entity.movie.MovieEntity
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.domain.model.MovieDetail
import javax.inject.Inject
import javax.inject.Singleton

private const val THE_MOVIE_DB_IMAGE_URL = BuildConfig.THE_MOVIE_DB_IMAGE_URL

@Singleton
class MovieEntityDataMapper @Inject constructor() {

    fun transform(data: List<MovieEntity>): List<Movie> {
        return data.map {
            Movie(
                id = it.id ?: 0,
                title = it.title ?: "",
                overview = it.overview ?: "",
                releaseDate = it.releaseDate ?: "",
                rate = it.voteAverage ?: 0f,
                imageUrl = "$THE_MOVIE_DB_IMAGE_URL${it.posterPath ?: ""}"
            )
        }
    }

    fun transform(data: MovieDetailEntity): MovieDetail {
        return MovieDetail(
            id = data.id ?: 0,
            title = data.title ?: "",
            overview = data.overview ?: "",
            backdropImageUrl = "$THE_MOVIE_DB_IMAGE_URL${data.backdropPath ?: ""}",
            rate = data.voteAverage?.toFloat() ?: 0f,
            genres = data.genres?.map { it.name ?: "" } ?: emptyList(),
            runtime = data.runtime ?: 0,
        )
    }
}