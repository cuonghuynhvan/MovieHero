package com.cuong.moviehero.ui.components

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
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