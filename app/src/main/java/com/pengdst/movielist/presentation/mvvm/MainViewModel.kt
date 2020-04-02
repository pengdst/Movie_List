package com.pengdst.movielist.presentation.mvvm

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.pengdst.movielist.BR
import com.pengdst.movielist.datas.routes.MovieRoute
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainViewModel(
    private val callback: MainViewModelCallback,
    private val movieRoute: MovieRoute
): BaseObservable(), HomeView {
    var progressBarVisibility: Int = View.GONE
    @Bindable get

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun discoverMovie() {
        progressBarVisibility = View.VISIBLE
        notifyPropertyChanged(progressBarVisibility)

        movieRoute.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(progressBarVisibility)
                callback.onSuccess(response.results)
            }, {error ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(progressBarVisibility)
                callback.onFailed(error)
            }
            ).addTo(disposable)
    }

    override fun onDetach() {
        disposable.clear()
    }
}