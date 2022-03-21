package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.modules.common.UIEventMessageType
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun SnackbarMessage(
    modifier: Modifier = Modifier,
    type: UIEventMessageType = UIEventMessageType.ERROR,
    message: String = "",
) {
    when(type) {
        UIEventMessageType.SUCCESS -> {
            SnackbarSuccessMessage(
                modifier = modifier,
                message = message,
            )
        }
        UIEventMessageType.NEUTRAL -> {
            SnackbarNeutralMessage(
                modifier = modifier,
                message = message,
            )
        }
        else -> {
            SnackbarErrorMessage(
                modifier = modifier,
                message = message,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarMessagePreview() {
    MovieHeroTheme {
        Column(
            modifier = Modifier
                .background(Color(0xffE5E5E5))
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            SnackbarMessage(
                type = UIEventMessageType.ERROR,
                message = "test message")
            Spacer(modifier = Modifier.height(16.dp))
            SnackbarMessage(
                type = UIEventMessageType.SUCCESS,
                message = "test message")


            Spacer(modifier = Modifier.height(16.dp))
            SnackbarMessage(
                type = UIEventMessageType.NEUTRAL,
                message = "test message")
        }
    }
}