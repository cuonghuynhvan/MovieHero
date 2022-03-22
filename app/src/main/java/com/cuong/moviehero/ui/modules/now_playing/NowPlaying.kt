package com.cuong.moviehero.ui.modules.now_playing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.ui.modules.common.movie_list.MovieList

@Composable
fun NowPlaying(
    modifier: Modifier = Modifier,
    viewModel: NowPlayingViewModel = hiltViewModel(),
    onOpenMovieDetail: (Movie) -> Unit,
) {

    MovieList(
        modifier = modifier,
        viewModel = viewModel,
        onOpenMovieDetail = onOpenMovieDetail,
    )
}