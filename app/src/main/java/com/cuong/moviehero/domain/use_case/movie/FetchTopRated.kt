package com.cuong.moviehero.domain.use_case.movie

import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.domain.repository.MovieRepository

class FetchTopRated(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): List<Movie> {
        return repository.fetchTopRated()
    }
}