package com.pengdst.movielist.presentation.mvvm

import androidx.lifecycle.LiveData

interface MainView {
    val state: LiveData<MainViewState>

    fun discoverMovie()
}