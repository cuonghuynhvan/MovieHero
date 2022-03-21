package com.cuong.moviehero.ui.modules.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class UIEventStateViewModel constructor(
    private val errorMessageHandler: ExceptionMessageHandler,
) : ViewModel() {
    private val _uiEventState = MutableSharedFlow<UIEventState>()
    val uiEventState = _uiEventState.asSharedFlow()

    private fun emitUIState(newState: UIEventState) {
        viewModelScope.launch {
            _uiEventState.emit(newState)
        }
    }

    fun emitUIMessage(messageResId: Int, type: Int = 0) {
        emitUIState(UIEventState(messageResId = messageResId))
    }

    open suspend fun transformExceptionToUIState(exception: Exception) {
        emitUIState(errorMessageHandler.createErrorMessageEvent(exception))
    }
}
