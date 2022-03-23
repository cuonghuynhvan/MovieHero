package com.cuong.moviehero.ui.modules.movie_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieDetail(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    movieId: String,
    onBackClick: () -> Unit,
) {
    val state: MovieDetailContentState by viewModel.state.collectAsState()
    LaunchedEffect(key1 = movieId, block = {
        viewModel.loadMovieDetail(movieId)
    })

    MovieDetailContent(
        state = state,
        onBackClick = onBackClick,
    )
}