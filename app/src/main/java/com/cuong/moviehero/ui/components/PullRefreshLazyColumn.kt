package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun PullRefreshLazyColumn(
    modifier: Modifier = Modifier,
    state: SwipeRefreshState = rememberSwipeRefreshState(false),
    onRefresh: () -> Unit = {},
    content: LazyListScope.() -> Unit = {},
) {
    SwipeRefresh(
        modifier = modifier,
        state = state,
        onRefresh = onRefresh,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PullRefreshLazyColumnReview() {
    MovieHeroTheme {
        PullRefreshLazyColumn()
    }
}