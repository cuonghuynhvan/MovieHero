package com.cuong.moviehero.ui.modules.movie_detail

import androidx.compose.runtime.Composable

@Composable
fun MovieDetail(
    onBackClick: () -> Unit = {},
) {
    MovieDetailContent(
        state = MovieDetailContentState(),
        onBackClick = onBackClick,
    )
}