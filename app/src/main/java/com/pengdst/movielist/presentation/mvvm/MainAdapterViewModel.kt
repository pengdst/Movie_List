package com.pengdst.movielist.presentation.mvvm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.pengdst.movielist.datas.models.Movie

class MainAdapterViewModel(movie: Movie): BaseObservable() {
    val title: String = movie.title
    @Bindable get

    val overview: String = movie.overview
    @Bindable get
}