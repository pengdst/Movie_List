package com.pengdst.movielist.presentation.mvvm

import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
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
    private val observer = MutableLiveData<MainViewState>()

    override fun discoverMovie() {
        movieRoute.discoverMovie()
            .map<MainViewState>(MainViewState::Success)
            .onErrorReturn(MainViewState::Error)
            .toFlowable()
            .startWith(MainViewState.loading)
            .subscribe(observer::postValue)
            .let (disposable::add)
    }

    override val state: LiveData<MainViewState>
        get() = observer

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}