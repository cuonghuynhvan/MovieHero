package com.cuong.moviehero.data.api

import com.cuong.moviehero.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIBuilder {
    private const val GOOGLE_BASE_URL = BuildConfig.GOOGLE_API_URL
    private const val THE_MOVIE_DB_API_URL = BuildConfig.THE_MOVIE_DB_API_URL

    private var retrofit: Retrofit? = null

    fun getGoogleInstance() : Retrofit = createRetroFitInstance(GOOGLE_BASE_URL)

    fun getMovieInstance() : Retrofit = createRetroFitInstance(THE_MOVIE_DB_API_URL)

    private fun createRetroFitInstance(baseUrl: String): Retrofit {
        if(retrofit ==  null) {
            val clientBuilder = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.apply {
                    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
                clientBuilder.addInterceptor(loggingInterceptor)
            }

            val client = clientBuilder.build()

            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!
    }
}
