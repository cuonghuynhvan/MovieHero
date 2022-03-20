package com.cuong.moviehero.ui.modules.location

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.components.GoogleMapWrapper
import com.cuong.moviehero.ui.components.SearchTextField
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun LocationContent() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMapWrapper(
            modifier = Modifier.fillMaxSize()
        )
        SearchTextField(
            modifier = Modifier
                .statusBarsPadding()
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = {},
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