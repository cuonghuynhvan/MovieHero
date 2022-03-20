package com.cuong.moviehero.ui.modules.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(LocationContentState())
    val state = _state.asStateFlow()

    val onSearchValueChange: (newValue: String) -> Unit = {
        viewModelScope.launch {
            _state.emit(_state.value.copy( searchValue = it ))
        }
    }

    val onSearch: () -> Unit = {
        viewModelScope.launch {

        }
    }
}