package com.cuong.moviehero.ui.modules.top_rated

import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.domain.use_case.movie.MovieUseCases
import com.cuong.moviehero.ui.modules.common.ExceptionMessageHandler
import com.cuong.moviehero.ui.modules.common.movie_list.MovieListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopRatedViewModel @Inject constructor(
    private val useCases: MovieUseCases,
    errorMessageHandler: ExceptionMessageHandler,
) : MovieListViewModel(errorMessageHandler) {
    override suspend fun loadMovieList(): List<Movie> = useCases.fetchTopRated()
}
