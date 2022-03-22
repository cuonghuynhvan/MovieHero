package com.cuong.moviehero.domain.repository

import com.cuong.moviehero.domain.model.Movie

interface MovieRepository {
    suspend fun fetchNowPlayings(): List<Movie>
    suspend fun fetchTopRated(): List<Movie>
}