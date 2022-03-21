package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun SnackbarSuccessMessage(
    modifier: Modifier = Modifier,
    message: String = "",
) {
    SnackbarNeutralMessage(
        modifier = modifier,
        backgroundColor = Color.Green,
        message = message,
        textColor = Color.White,
    )
}

@Preview(showBackground = true)
@Composable
fun SnackbarSuccessMessagePreview() {
    MovieHeroTheme {
        Column(
            modifier = Modifier
                .background(Color(0xffE5E5E5))
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            SnackbarSuccessMessage(message = "test message")
            Spacer(modifier = Modifier.height(16.dp))
            SnackbarSuccessMessage(message = "this is a snackbar with very long message very very long message so that it can be in 2 lines")
        }
    }
}