package com.cuong.moviehero.ui.modules.movie_detail

import androidx.lifecycle.viewModelScope
import com.cuong.moviehero.R
import com.cuong.moviehero.domain.exception.NeedRequestLocationPermissionException
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Place
import com.cuong.moviehero.domain.use_case.location.LocationUseCases
import com.cuong.moviehero.domain.use_case.movie.MovieUseCases
import com.cuong.moviehero.ui.modules.common.ExceptionMessageHandler
import com.cuong.moviehero.ui.modules.common.UIEventStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val useCases: MovieUseCases,
    errorMessageHandler: ExceptionMessageHandler,
) : UIEventStateViewModel(errorMessageHandler) {

    private val _state = MutableStateFlow(
        MovieDetailContentState()
    )
    val state = _state.asStateFlow()

    fun loadMovieDetail(movieId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.emit(_state.value.copy(showLoading = true))
            try {
                _state.emit(_state.value.copy(movieDetail = useCases.fetchMovieDetail(movieId)))
            } catch (exception: Exception) {
                transformExceptionToUIState(exception)
            } finally {
                delay(50L)
                _state.emit(_state.value.copy(showLoading = false))
            }
        }
    }
}