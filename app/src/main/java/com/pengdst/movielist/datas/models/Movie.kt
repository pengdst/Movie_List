package com.pengdst.movielist.datas.models

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("title")
    val title: String?,
    @SerializedName("overview")
    val overview: String?
)

data class MovieResponse (
    @SerializedName("results")
    val results: List<Movie>
)