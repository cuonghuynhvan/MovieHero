package com.cuong.moviehero.ui.modules.location

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cuong.moviehero.ui.components.map.GoogleMapWrapper
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun LocationContent() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMapWrapper(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentReview() {
    MovieHeroTheme() {
        LocationContent()
    }
}