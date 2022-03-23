package com.cuong.moviehero.domain.use_case.movie

data class MovieUseCases(
    val fetchNowPlaying: FetchNowPlaying,
    val fetchTopRated: FetchTopRated,
    val fetchMovieDetail: FetchMovieDetail,
)