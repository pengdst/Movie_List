package com.pengdst.movielist.presentation

import com.pengdst.movielist.datas.models.MovieResponse
import com.pengdst.movielist.datas.routes.MovieRoute
import com.pengdst.movielist.di.module.RetrofitModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(
    private val mainView: MainView,
    private val movieRoute: MovieRoute
) {
    fun getDiscoverMovie(){
        mainView.showLoading()

        movieRoute.discoverMovie().enqueue(object: Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                mainView.hideLoading()
                mainView.onFailed(t)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                mainView.hideLoading()
                mainView.onSuccess(response.body()?.results ?: emptyList())
            }

        })
    }
}