package com.cuong.moviehero.ui.modules.search_place

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import com.cuong.moviehero.domain.model.Place

@Composable
fun SearchPlace(
    viewModel: SearchPlaceViewModel = hiltViewModel(),
    onPlaceItemClick: (place: Place) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val state: SearchPlaceContentState by viewModel.state.collectAsState()

    val handlePlaceItemClick: (place:Place) -> Unit = remember(onPlaceItemClick) {{
        focusManager.clearFocus()
        viewModel.onPlaceItemClick()
        onPlaceItemClick(it)
    }}

    SearchPlaceContent(
        state = state,
        onSearchValueChange = viewModel.onSearchValueChange,
        onSearch = viewModel.onSearch,
        onPlaceItemClick = handlePlaceItemClick,
    )
}
