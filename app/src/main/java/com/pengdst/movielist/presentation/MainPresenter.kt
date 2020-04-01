package com.pengdst.movielist.presentation

import com.pengdst.movielist.datas.models.MovieResponse
import com.pengdst.movielist.datas.routes.MovieRoute
import com.pengdst.movielist.di.module.RetrofitModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(
    private val mainView: MainView,
    private val movieRoute: MovieRoute) {

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun getDiscoverMovie(){
        mainView.showLoading()

        movieRoute.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {response ->
                    mainView.hideLoading()
                    mainView.onSuccess(response.results)
                }, {error ->
                    mainView.hideLoading()
                    mainView.onFailed(error)
                }
            ).addTo(disposable)
    }

    fun onDettach(){
        disposable.clear()
    }
}