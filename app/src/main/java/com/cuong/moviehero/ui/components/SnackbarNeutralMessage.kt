package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun SnackbarNeutralMessage(
    modifier: Modifier = Modifier,
    backgroundColor: Color = White,
    textColor: Color = Color.Black,
    shape: Shape = RoundedCornerShape(8.dp),
    message: String = "",
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .shadow(4.dp, shape = shape)
            .background(color = backgroundColor, shape = shape)
            .padding(16.dp)

    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.body2.copy(textColor),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarNeutralMessagePreview() {
    MovieHeroTheme {
        Column(
            modifier = Modifier
                .background(Color(0xffE5E5E5))
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            SnackbarNeutralMessage(message = "test message")
            Spacer(modifier = Modifier.height(16.dp))
            SnackbarNeutralMessage(message = "this is a snackbar with very long message very very long message so that it can be in 2 lines")
        }
    }
}