package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun BottomTabBar(
    modifier: Modifier = Modifier,
    activeIndex: Int = 0,
    onTabClick: (Int) -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
            .navigationBarsPadding()
            .height(70.dp),
    ) {
        TabButton(
            modifier = Modifier.fillMaxHeight().weight(1f),
            text = stringResource(id = R.string.button_tab_now_playing),
            icon = painterResource(id = R.drawable.ic_now_playing),
            isActive = activeIndex == 0,
            onClick = { onTabClick(0) }
        )
        VerticalLine()
        TabButton(
            modifier = Modifier.fillMaxHeight().weight(1f),
            text = stringResource(id = R.string.button_tab_top_rated),
            icon = painterResource(id = R.drawable.ic_top_rate),
            isActive = activeIndex == 1,
            onClick = { onTabClick(1) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomTabBarPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            BottomTabBar()
        }
    }
}