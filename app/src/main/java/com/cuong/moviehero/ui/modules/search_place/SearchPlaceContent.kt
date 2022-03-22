package com.cuong.moviehero.ui.modules.search_place

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.ui.components.Loading
import com.cuong.moviehero.ui.components.PlaceLazyColumn
import com.cuong.moviehero.ui.components.SearchTextField
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun SearchPlaceContent(
    state: SearchPlaceContentState,
    onSearchValueChange: (newValue: String) -> Unit,
    onSearch: () -> Unit,
    onPlaceItemClick: (place:Place) -> Unit,
) {
    var isFocusSearchBox: Boolean by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(
                if (isFocusSearchBox) {
                    Modifier.pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                focusManager.clearFocus()
                            }
                        )
                    }
                } else Modifier
            )

    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .onFocusChanged {
                    isFocusSearchBox = it.isFocused
                },
            placeholder = stringResource(id = R.string.placeholder_search),
            value = state.searchValue,
            onValueChange = onSearchValueChange,
            onSearch = onSearch,
        )
        if(state.showResultContent) {
            BoxWithConstraints(
                modifier = Modifier
                    .navigationBarsPadding()
                    .imePadding()
                    .fillMaxSize(),
            ) {
                PlaceLazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    data = state.placeList,
                    onItemClick = onPlaceItemClick,
                )

                Loading(
                    modifier = Modifier.align(Alignment.Center),
                    show = state.showLoading,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPlaceContentReview() {
    MovieHeroTheme {
        Surface() {
            SearchPlaceContent(
                state = SearchPlaceContentState(
                    placeList = listOf(
                        Place("1", "Name 1", "Address 1"),
                        Place("2", "Name 2", "Address 2"),
                        Place("3", "Name 3", "Address 3"),
                        Place("4", "Name 4", "Address 4"),
                    )
                ),
                onSearchValueChange = {},
                onSearch = {},
                onPlaceItemClick = {},
            )
        }
    }
}