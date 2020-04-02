package com.pengdst.movielist.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pengdst.movielist.datas.routes.MovieRoute
import io.reactivex.disposables.CompositeDisposable
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