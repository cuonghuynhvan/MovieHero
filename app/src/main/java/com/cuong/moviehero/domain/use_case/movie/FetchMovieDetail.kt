package com.cuong.moviehero.domain.use_case.movie

import com.cuong.moviehero.domain.model.MovieDetail
import com.cuong.moviehero.domain.repository.MovieRepository

class FetchMovieDetail(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: String): MovieDetail {
        return repository.fetchMovieDetail(movieId)
    }
}