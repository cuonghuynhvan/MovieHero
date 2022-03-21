package com.cuong.moviehero.ui.modules.location

import androidx.lifecycle.viewModelScope
import com.cuong.moviehero.R
import com.cuong.moviehero.domain.exception.NeedRequestLocationPermissionException
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.use_case.LocationUseCases
import com.cuong.moviehero.ui.modules.common.ExceptionMessageHandler
import com.cuong.moviehero.ui.modules.common.UIEventStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val useCases: LocationUseCases,
    errorMessageHandler: ExceptionMessageHandler,
) : UIEventStateViewModel(errorMessageHandler) {

    private val _state = MutableStateFlow(
        LocationContentState(
            currentLocation = GPSPoint(10.8020047, 106.6391917) // TODO remove this hard code
        )
    )
    val state = _state.asStateFlow()

    private val _requestPermissionState = MutableSharedFlow<Boolean>()
    val requestPermissionState = _requestPermissionState.asSharedFlow()

    val onCurrentLocationClick: () -> Unit = {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _state.emit(
                    _state.value.copy(
                        currentLocation = useCases.requestCurrentLocation()
                    )
                )
            } catch (exception: Exception) {
                transformExceptionToUIState(exception)
            }
        }
    }

    val onUserDisallowToShowAgain: () -> Unit = {
        viewModelScope.launch {
            _requestPermissionState.emit(false)
            emitUIMessage(R.string.error_message_location_permission_denied)
        }
    }

    val onDismissRequestPermission: () -> Unit = {
        viewModelScope.launch {
            _requestPermissionState.emit(false)
        }
    }

    fun requestCurrentLocationWhenStart() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _state.emit(
                    _state.value.copy(
                        currentLocation = useCases.requestCurrentLocation()
                    )
                )
            } catch (exception: Exception) {}
        }
    }

    fun onDispose() {
        useCases.stopLocationUpdate()
    }

    override suspend fun transformExceptionToUIState(exception: Exception) {
        when (exception) {
            is NeedRequestLocationPermissionException -> _requestPermissionState.emit(true)
            else -> super.transformExceptionToUIState(exception)
        }
    }
}