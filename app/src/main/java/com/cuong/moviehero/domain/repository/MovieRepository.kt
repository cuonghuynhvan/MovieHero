package com.cuong.moviehero.domain.repository

import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.domain.model.MovieDetail

interface MovieRepository {
    suspend fun fetchNowPlayings(): List<Movie>
    suspend fun fetchTopRated(): List<Movie>
    suspend fun fetchMovieDetail(movieId: String): MovieDetail
}