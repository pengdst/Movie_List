package com.pengdst.movielist.presentation.mvvm

import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pengdst.movielist.datas.routes.MovieRoute
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val movieRoute: MovieRoute
): ViewModel(), MainView {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private val observable: MutableLiveData<MainViewState>

    override fun discoverMovie() {
        movieRoute.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                callback.onSuccess(response.results)
            }, {error ->
                callback.onFailed(error)
            }
            ).addTo(disposable)
    }

    override fun onDetach() {
        disposable.clear()
    }
}