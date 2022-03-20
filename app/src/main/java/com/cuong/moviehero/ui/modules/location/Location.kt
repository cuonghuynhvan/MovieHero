package com.cuong.moviehero.ui.modules.location

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Location(
    viewModel: LocationViewModel = hiltViewModel()
) {
    val state: LocationContentState by viewModel.state.collectAsState(LocationContentState())

    LocationContent(
        state = state,
        onSearchValueChange = viewModel.onSearchValueChange,
        onSearch = viewModel.onSearch,
    )
}