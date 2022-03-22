package com.cuong.moviehero.data.api

import com.cuong.moviehero.BuildConfig
import com.cuong.moviehero.data.entity.movie.MovieListResult
import retrofit2.http.GET
import retrofit2.http.Query

private const val THE_MOVIE_DB_API_KEY = BuildConfig.THE_MOVIE_DB_API_KEY
interface MovieApiService {
    @GET("3/movie/now_playing")
    suspend fun fetchNowPlaying(@Query("api_key") apiKey: String = THE_MOVIE_DB_API_KEY): MovieListResult

    @GET("3/movie/top_rated")
    suspend fun fetchTopRated(@Query("api_key") apiKey: String = THE_MOVIE_DB_API_KEY): MovieListResult
}