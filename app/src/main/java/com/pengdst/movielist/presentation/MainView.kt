package com.pengdst.movielist.presentation

import com.pengdst.movielist.datas.models.Movie

interface MainView {
    fun onSuccess(result: List<Movie>)
    fun onFailed(error: Throwable)
    fun showLoading()
    fun hideLoading()
}