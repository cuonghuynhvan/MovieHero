package com.cuong.moviehero.ui.modules.common.movie_list

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.ui.components.*
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun NowPlayingContent(
    modifier: Modifier = Modifier,
    state: MovieListContentState,
    onItemClick: (Movie) -> Unit,
    onRefresh: () -> Unit,
) {
    val pullRefreshState: SwipeRefreshState = rememberSwipeRefreshState(false)

    LaunchedEffect(key1 = state.showRefreshing, block = {
        pullRefreshState.isRefreshing = state.showRefreshing
    })

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        PullRefreshLazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = pullRefreshState,
            onRefresh = onRefresh,
        ) {
            items(state.movieList, key = { it.id }) { movie ->
                MovieItem(
                    modifier = Modifier.fillMaxWidth(),
                    title = movie.title,
                    overview = movie.overview,
                    imageUrl = movie.imageUrl,
                    releaseDate = movie.releaseDate,
                    rate = movie.rate,
                    onClick = { onItemClick(movie) }
                )
                HorizontalLine()
            }
        }

        Loading(
            modifier = Modifier.align(Alignment.Center),
            show = state.showLoading,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieListContentReview() {
    MovieHeroTheme {
        NowPlayingContent(
            state = MovieListContentState(),
            onItemClick = {},
            onRefresh = {},
        )
    }
}