package com.cuong.moviehero.ui.modules.home

import androidx.compose.runtime.Composable
import com.cuong.moviehero.ui.components.GlobalNavigationBarsAppearance

@Composable
fun Home(
) {

    GlobalNavigationBarsAppearance(false)
    HomeContent()
}