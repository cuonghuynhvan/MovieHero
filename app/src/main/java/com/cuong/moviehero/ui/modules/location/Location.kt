package com.cuong.moviehero.ui.modules.location

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.ui.components.LocalSnackbarManager
import com.cuong.moviehero.ui.components.RequestLocationPermission
import com.cuong.moviehero.ui.modules.common.ExceptionMessageComposable
import com.cuong.moviehero.ui.modules.common.UIEventState
import com.cuong.moviehero.ui.modules.search_place.SearchPlace
import kotlinx.coroutines.launch

@Composable
fun Location(
    viewModel: LocationViewModel = hiltViewModel()
) {
    val state: LocationContentState by viewModel.state.collectAsState()
    val requestPermission: Boolean by viewModel.requestPermissionState.collectAsState(false)
    val uiEventState: UIEventState by viewModel.uiEventState.collectAsState(UIEventState())

    LaunchedEffect(key1 = true, block = {
        viewModel.requestCurrentLocationWhenStart()
    })
    DisposableEffect(LocalLifecycleOwner.current) {
        onDispose {
            viewModel.onDispose()
        }
    }

    ExceptionMessageComposable(uiEventState)
    RequestLocationPermission(
        showRequest = requestPermission,
        onAllPermissionGranted = viewModel.onCurrentLocationClick,
        onDismissRequest = viewModel.onDismissRequestPermission,
        onUserDisallowToShowAgain = viewModel.onUserDisallowToShowAgain,
    )
    LocationContent(
        state = state,
        searchContent = {
            SearchPlace()
        },
        onCurrentLocationClick = viewModel.onCurrentLocationClick,
    )
}