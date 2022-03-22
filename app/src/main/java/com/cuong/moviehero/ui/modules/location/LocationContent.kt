package com.cuong.moviehero.ui.modules.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.components.GoogleMapWrapper
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun LocationContent(
    state: LocationContentState,
    searchContent: @Composable () -> Unit,
    onCurrentLocationClick: () -> Unit,
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        GoogleMapWrapper(
            modifier = Modifier.fillMaxSize(),
            centerPoint = state.centerPoint,
            centerPointName = state.centerPointName,
            showCenterPointPin = state.showCenterPointPin,
            showDirection = state.showDirection,
            direction = state.direction,
        )
        OutlinedButton(
            modifier= Modifier.align(Alignment.BottomEnd)
                .navigationBarsPadding()
                .padding(end = 16.dp, bottom = 32.dp)
                .size(60.dp)
                .background(Color.White, shape = CircleShape)
                .shadow(elevation = 4.dp, shape = CircleShape),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            onClick = onCurrentLocationClick,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_current_location),
                contentDescription = ""
            )
        }

        searchContent()
    }
}

@Preview(showBackground = true)
@Composable
fun LocationContentReview() {
    MovieHeroTheme {
        LocationContent(
            state = LocationContentState(),
            searchContent = {},
            onCurrentLocationClick = {},
        )
    }
}