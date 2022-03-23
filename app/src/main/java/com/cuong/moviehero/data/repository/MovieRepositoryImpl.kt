package com.cuong.moviehero.data.repository

import com.cuong.moviehero.data.api.MovieApiService
import com.cuong.moviehero.data.entity.mapper.MovieEntityDataMapper
import com.cuong.moviehero.domain.exception.NetworkConnectionException
import com.cuong.moviehero.domain.model.Movie
import com.cuong.moviehero.domain.model.MovieDetail
import com.cuong.moviehero.domain.repository.MovieRepository
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MovieRepositoryImpl(
    private val movieApiService: MovieApiService,
    private val movieEntityDataMapper: MovieEntityDataMapper,
) : MovieRepository {

    override suspend fun fetchNowPlayings(): List<Movie> {
        try {
            val result = movieApiService.fetchNowPlaying()
            return if (result.results != null) movieEntityDataMapper.transform(result.results)
            else throw NetworkConnectionException("internet connection issue")
        } catch (e: HttpException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: SocketTimeoutException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: UnknownHostException) {
            throw NetworkConnectionException("internet connection issue")
        }
    }

    override suspend fun fetchTopRated(): List<Movie> {
        try {
            val result = movieApiService.fetchTopRated()
            return if (result.results != null) movieEntityDataMapper.transform(result.results)
            else throw NetworkConnectionException("internet connection issue")
        } catch (e: HttpException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: SocketTimeoutException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: UnknownHostException) {
            throw NetworkConnectionException("internet connection issue")
        }
    }

    override suspend fun fetchMovieDetail(movieId: String): MovieDetail {
        try {
            val result = movieApiService.fetchMovieDetail(movieId)
            return movieEntityDataMapper.transform(result)
        } catch (e: HttpException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: SocketTimeoutException) {
            throw NetworkConnectionException("internet connection issue")
        } catch (e: UnknownHostException) {
            throw NetworkConnectionException("internet connection issue")
        }
    }
}
