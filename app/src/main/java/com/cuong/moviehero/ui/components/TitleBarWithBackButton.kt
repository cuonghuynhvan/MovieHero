package com.cuong.moviehero.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun TitleBarWithBackButton(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    onBackClick: () -> Unit = {},
    tintColor: Color = MaterialTheme.colors.onPrimary,
) {
    TitleBar(
        modifier = modifier,
        title = title,
        startContent = {
            IconButton(
                onClick = onBackClick,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_button),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = tintColor)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TitleBarWithBackButtonPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            TitleBarWithBackButton()
        }
    }
}