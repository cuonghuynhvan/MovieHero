package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun HorizontalLine(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
    thickness: Dp = 1.dp,
) {
    Divider(modifier = Modifier
        .fillMaxWidth()
        .then(modifier), color = color, thickness = thickness)
}

@Preview
@Composable
fun HorizontalLineReview() {
    MovieHeroTheme {
        Column {
            HorizontalLine()
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalLine(
                modifier = Modifier.width(300.dp)
            )
        }
    }
}