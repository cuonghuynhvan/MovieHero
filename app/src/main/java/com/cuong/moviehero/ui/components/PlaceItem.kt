package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun PlaceItem(
    modifier: Modifier = Modifier,
    name: String = "",
    address: String = "",
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .clickable(role = Role.Button, onClick = onClick)
            .padding(16.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = name,
            style = MaterialTheme.typography.body1.plus(
                TextStyle(MaterialTheme.colors.onBackground)),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = address,
            style = MaterialTheme.typography.body2.plus(
                TextStyle(MaterialTheme.colors.onBackground)),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceItemPreview() {
    MovieHeroTheme {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            PlaceItem(
                name = "name",
                address = "address",
            )
        }
    }
}