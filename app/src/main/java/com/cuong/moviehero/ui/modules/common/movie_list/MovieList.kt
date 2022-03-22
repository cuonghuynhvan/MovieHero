package com.cuong.moviehero.ui.modules.common.movie_list

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.ui.modules.common.ExceptionMessageComposable
import com.cuong.moviehero.ui.modules.common.UIEventState

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel,
    onOpenMovieDetail: (Movie) -> Unit,
) {
    val state: MovieListContentState by viewModel.state.collectAsState()
    val uiEventState: UIEventState by viewModel.uiEventState.collectAsState(UIEventState())

    LaunchedEffect(key1 = true, block = {
        viewModel.loadData()
    })

    ExceptionMessageComposable(uiEventState)
    NowPlayingContent(
        modifier = modifier,
        state = state,
        onItemClick = onOpenMovieDetail,
        onRefresh = viewModel.onRefresh,
    )
}