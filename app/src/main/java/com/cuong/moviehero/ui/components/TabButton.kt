package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun TabButton(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: Painter = painterResource(id = R.drawable.ic_now_playing),
    isActive: Boolean = false,
    activeColor: Color = MaterialTheme.colors.onPrimary,
    normalColor: Color = MaterialTheme.colors.onPrimary.copy(alpha = 0.6f),
    onClick: () -> Unit = {},
) {
    val color = if (isActive) activeColor else normalColor

    Column(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .clickable(
                role = Role.Button,
                onClick = onClick,
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(painter = icon, tint = color, contentDescription = null)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.h4.copy(color)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TabButtonPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant)
                .padding(16.dp)
        ) {
            TabButton(
                text = "Now playing",
                isActive = false
            )
            TabButton(
                text = "Now playing",
                isActive = true
            )
        }
    }
}