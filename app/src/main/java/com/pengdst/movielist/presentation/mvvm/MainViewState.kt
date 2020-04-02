package com.pengdst.movielist.presentation.mvvm

import com.pengdst.movielist.datas.models.MovieResponse

sealed class MainViewState {
    object loading: MainViewState()

    data class Success(val response: MovieResponse): MainViewState()
    data class Error(val t: Throwable): MainViewState()
}