package com.cuong.moviehero.ui.modules.location

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cuong.moviehero.ui.components.GoogleMapWrapper
import com.cuong.moviehero.ui.components.SearchTextField
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun LocationContent(
    state: LocationContentState,
    searchContent: @Composable () -> Unit,
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        GoogleMapWrapper(modifier = Modifier.fillMaxSize())
        searchContent()
    }
}

@Preview(showBackground = true)
@Composable
fun LocationContentReview() {
    MovieHeroTheme() {
        LocationContent(
            state = LocationContentState(),
            searchContent = {}
        )
    }
}