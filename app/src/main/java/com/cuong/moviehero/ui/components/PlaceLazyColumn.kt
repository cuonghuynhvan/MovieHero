package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun PlaceLazyColumn(
    modifier: Modifier = Modifier,
    data: List<Place> = emptyList(),
    shape: Shape = RoundedCornerShape(16.dp),
    onItemClick: (place: Place) -> Unit = {}
) {
    Surface(
        modifier = modifier,
        elevation = 4.dp,
        shape = shape,
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
        ) {
            items(data, key = { it.id }) { place ->
                PlaceItem(
                    modifier = Modifier.fillMaxWidth(),
                    name = place.name,
                    address = place.address,
                    onClick = { onItemClick(place) }
                )
                HorizontalLine()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceLazyColumnPreview() {
    MovieHeroTheme {
        Column {
            PlaceLazyColumn(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                data = listOf(
                    Place("1", "Name 1", "Address 1"),
                    Place("2", "Name 2", "Address 2"),
                    Place("3", "Name 3", "Address 3"),
                    Place("4", "Name 4", "Address 4"),
                )
            )
        }

    }
}