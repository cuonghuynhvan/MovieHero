package com.cuong.moviehero.ui.modules.location

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Location(
    viewModel: LocationViewModel = hiltViewModel()
) {
    LocationContent()
}