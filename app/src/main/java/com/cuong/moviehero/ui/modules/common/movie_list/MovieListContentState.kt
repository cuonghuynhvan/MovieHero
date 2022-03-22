package com.cuong.moviehero.ui.modules.common.movie_list

import androidx.compose.runtime.Immutable
import com.cuong.moviehero.domain.model.Movie

@Immutable
data class MovieListContentState(
    val showLoading: Boolean = false,
    val showRefreshing: Boolean = false,
    val movieList: List<Movie> = emptyList(),
)
