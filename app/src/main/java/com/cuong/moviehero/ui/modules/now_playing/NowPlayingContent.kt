package com.cuong.moviehero.ui.modules.now_playing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cuong.moviehero.ui.components.HorizontalLine
import com.cuong.moviehero.ui.components.MovieItem
import com.cuong.moviehero.ui.components.PullRefreshLazyColumn
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun NowPlayingContent(

) {
    PullRefreshLazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            MovieItem(
                imageUrl = "https://image.tmdb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
                title = "name",
                releaseDate = "2020/11/20",
                overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                rate = 6.5f,
            )
            HorizontalLine()
        }
        item {
            MovieItem(
                imageUrl = "https://image.tmdb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
                title = "name",
                releaseDate = "2020/11/20",
                overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                rate = 6.5f,
            )
            HorizontalLine()
        }
        item {
            MovieItem(
                imageUrl = "https://image.tmdb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
                title = "name",
                releaseDate = "2020/11/20",
                overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                rate = 6.5f,
            )
            HorizontalLine()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NowPlayingContentReview() {
    MovieHeroTheme {
        NowPlayingContent()
    }
}