package com.cuong.moviehero.ui.modules.search_place

import androidx.compose.runtime.Immutable
import com.cuong.moviehero.domain.model.Place

@Immutable
data class SearchPlaceContentState (
    val searchValue: String = "",
    val showLoading: Boolean = false,
    val showResultContent: Boolean = false,
    val placeList: List<Place> = emptyList(),
)