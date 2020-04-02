package com.pengdst.movielist.presentation.mvvm

import com.pengdst.movielist.datas.models.Movie

interface MainViewModelCallback {
    fun onSuccess(results: List<Movie>)
    fun onFailed(error: Throwable)
}
