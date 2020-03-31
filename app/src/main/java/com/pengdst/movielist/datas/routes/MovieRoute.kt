package com.pengdst.movielist.datas.routes

import com.pengdst.movielist.BuildConfig
import com.pengdst.movielist.datas.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRoute {
    @GET("discover/movie")
    fun discoverMovie(
        @Query(value = "api_key")
        apikey: String = BuildConfig.API_KEY
    ):Call<MovieResponse>
}