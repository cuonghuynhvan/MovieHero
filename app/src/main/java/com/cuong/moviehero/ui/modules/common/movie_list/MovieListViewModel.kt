package com.cuong.moviehero.ui.modules.common.movie_list

import androidx.lifecycle.viewModelScope
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.ui.modules.common.ExceptionMessageHandler
import com.cuong.moviehero.ui.modules.common.UIEventStateViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class MovieListViewModel constructor(
    errorMessageHandler: ExceptionMessageHandler,
) : UIEventStateViewModel(errorMessageHandler) {
    private val _state = MutableStateFlow(MovieListContentState())
    val state = _state.asStateFlow()

    val onRefresh: () -> Unit = {
        viewModelScope.launch(Dispatchers.IO) {
            if(_state.value.showLoading || _state.value.showLoading) {
                return@launch
            }

            _state.emit(_state.value.copy(showRefreshing = true))
            try {
                _state.emit(_state.value.copy(movieList = loadMovieList()))
            } catch (exception: Exception) {
                transformExceptionToUIState(exception)
            } finally {
                delay(50L)
                _state.emit(_state.value.copy(showRefreshing = false))
            }
        }
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            if(_state.value.movieList.isNotEmpty()) {
                return@launch
            }

            _state.emit(_state.value.copy(showLoading = true))
            try {
                _state.emit(_state.value.copy(movieList = loadMovieList()))
            } catch (exception: Exception) {
                transformExceptionToUIState(exception)
            } finally {
                _state.emit(_state.value.copy(showLoading = false))
            }
        }
    }

    abstract suspend fun loadMovieList(): List<Movie>
}
