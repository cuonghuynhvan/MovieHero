package com.cuong.moviehero.ui.modules.search_place

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchPlace(
    viewModel: SearchPlaceViewModel = hiltViewModel()
) {
    val state: SearchPlaceContentState by viewModel.state.collectAsState(SearchPlaceContentState())

    SearchPlaceContent(
        state = state,
        onSearchValueChange = viewModel.onSearchValueChange,
        onSearch = viewModel.onSearch,
    )
}