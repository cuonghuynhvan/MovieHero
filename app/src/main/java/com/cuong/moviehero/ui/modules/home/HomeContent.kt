package com.cuong.moviehero.ui.modules.home

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.ui.components.BottomTabBar
import com.cuong.moviehero.ui.components.LocalSnackbarManager
import com.cuong.moviehero.ui.components.RequestLocationPermission
import com.cuong.moviehero.ui.components.TitleBar
import com.cuong.moviehero.ui.modules.common.ExceptionMessageComposable
import com.cuong.moviehero.ui.modules.common.UIEventState
import com.cuong.moviehero.ui.modules.location.LocationContent
import com.cuong.moviehero.ui.modules.location.LocationContentState
import com.cuong.moviehero.ui.modules.search_place.SearchPlace
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import kotlinx.coroutines.launch

@Composable
fun HomeContent(
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TitleBar()
        },
        content = {

        },
        bottomBar = {
            BottomTabBar()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LocationContentReview() {
    MovieHeroTheme {
        HomeContent()
    }
}