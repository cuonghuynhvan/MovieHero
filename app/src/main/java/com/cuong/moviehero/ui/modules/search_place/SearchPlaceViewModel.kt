package com.cuong.moviehero.ui.modules.search_place

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuong.moviehero.domain.use_case.LocationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchPlaceViewModel @Inject constructor(
    private val useCases: LocationUseCases,
) : ViewModel() {

    private val _state = MutableStateFlow(SearchPlaceContentState())
    val state = _state.asStateFlow()

    val onSearchValueChange: (newValue: String) -> Unit = {
        viewModelScope.launch {
            if(_state.value.showLoading) {
                return@launch
            }

            _state.emit(_state.value.copy( searchValue = it ))
        }
    }

    val onSearch: () -> Unit = {
        viewModelScope.launch {
            if(_state.value.searchValue.isEmpty() || _state.value.showLoading) {
                return@launch
            }

            _state.emit(_state.value.copy( showResultContent = true, showLoading = true ))
            val placeList = useCases.searchPlaces(_state.value.searchValue)
            _state.emit(_state.value.copy( showResultContent = true, showLoading = false, placeList = placeList ))
        }
    }
}