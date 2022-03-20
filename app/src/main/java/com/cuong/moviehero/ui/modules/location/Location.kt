package com.cuong.moviehero.ui.modules.location

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.cuong.moviehero.ui.modules.search_place.SearchPlace

@Composable
fun Location(
    viewModel: LocationViewModel = hiltViewModel()
) {
    LocationContent(
        state = LocationContentState(),
        searchContent = {
            SearchPlace()
        }
    )
}