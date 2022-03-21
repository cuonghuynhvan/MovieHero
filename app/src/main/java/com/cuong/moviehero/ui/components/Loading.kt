package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun Loading(
    modifier: Modifier = Modifier,
    show: Boolean = false,
) {
    if(show) {
        Text(
            modifier = modifier
                .background(
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(32.dp),
            text = stringResource(id = R.string.label_loading),
            style = MaterialTheme.typography.h3,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Loading()
        }
    }
}