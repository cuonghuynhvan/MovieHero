package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun RuntimeText(
    modifier: Modifier = Modifier,
    runtime: Int = 0,
) {
    val hour: Int = runtime / 60
    val min: Int = runtime % 60

    Text(
        modifier = modifier,
        text = stringResource(id = R.string.text_runtime, hour, min),
        style = MaterialTheme.typography.body2.copy(
            color = MaterialTheme.colors.onBackground,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun RuntimeTextPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            RuntimeText(runtime = 142)
        }
    }
}