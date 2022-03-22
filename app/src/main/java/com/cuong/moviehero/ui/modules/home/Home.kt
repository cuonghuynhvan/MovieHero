package com.cuong.moviehero.ui.modules.home

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.cuong.moviehero.ui.components.GlobalNavigationBarsAppearance
import com.cuong.moviehero.ui.modules.now_playing.NowPlaying
import com.cuong.moviehero.ui.modules.top_rated.TopRated

@Composable
fun Home(
) {
    var tabIndex: Int by rememberSaveable { mutableStateOf(0) }

    GlobalNavigationBarsAppearance(false)
    HomeContent(
        activeIndex = tabIndex,
        onTabClick = { tabIndex = it }
    ) {
        when (tabIndex) {
            0 -> NowPlaying()
            else -> TopRated()
        }
    }
}