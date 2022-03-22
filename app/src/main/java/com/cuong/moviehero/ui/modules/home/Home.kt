package com.cuong.moviehero.ui.modules.home

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.ui.components.GlobalNavigationBarsAppearance
import com.cuong.moviehero.ui.modules.now_playing.NowPlaying
import com.cuong.moviehero.ui.modules.top_rated.TopRated

@Composable
fun Home(
    onOpenMovieDetail: (Movie) -> Unit,
) {
    var tabIndex: Int by rememberSaveable { mutableStateOf(0) }

    GlobalNavigationBarsAppearance(false)
    HomeContent(
        activeIndex = tabIndex,
        onTabClick = { tabIndex = it }
    ) {
        when (tabIndex) {
            0 -> NowPlaying(modifier = Modifier.padding(it), onOpenMovieDetail = onOpenMovieDetail)
            else -> TopRated(modifier = Modifier.padding(it), onOpenMovieDetail = onOpenMovieDetail)
        }
    }
}