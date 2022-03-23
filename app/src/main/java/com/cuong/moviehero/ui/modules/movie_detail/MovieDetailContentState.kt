package com.cuong.moviehero.ui.modules.movie_detail

import androidx.compose.runtime.Immutable
import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.MovieDetail

@Immutable
data class MovieDetailContentState(
    val movieDetail: MovieDetail = MovieDetail(),
    val showLoading: Boolean = false,
)
