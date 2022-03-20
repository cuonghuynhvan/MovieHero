package com.cuong.moviehero.ui.modules.location

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cuong.moviehero.ui.components.GoogleMapWrapper
import com.cuong.moviehero.ui.components.SearchTextField
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun LocationContent(
    state: LocationContentState,
    onSearchValueChange: (newValue: String) -> Unit,
    onSearch: () -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMapWrapper(
            modifier = Modifier.fillMaxSize()
        )

        val (searchBar, searchResult) = createRefs()
        SearchTextField(
            modifier = Modifier
                .constrainAs(searchBar) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
                .statusBarsPadding(),
            value = state.searchValue,
            onValueChange = onSearchValueChange,
            onSearch = onSearch,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LocationContentReview() {
    MovieHeroTheme() {
        LocationContent(
            state = LocationContentState(),
            onSearchValueChange = {},
            onSearch = {},
        )
    }
}