package com.pengdst.movielist.di.module

import com.pengdst.movielist.datas.routes.MovieRoute
import com.pengdst.movielist.presentation.MainActivity
import com.pengdst.movielist.presentation.MainPresenter
import com.pengdst.movielist.presentation.MainView
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class MainModule {

    @Module
    companion object{

        @JvmStatic
        @Provides
        fun provideMovieRoute(retrofit: Retrofit): MovieRoute =
            retrofit.create(MovieRoute::class.java)

        @JvmStatic
        @Provides
        fun provideMainPresenter(
            mainView: MainView,
            movieRoute: MovieRoute
        ): MainPresenter = MainPresenter(mainView, movieRoute)
    }

    @Binds
    abstract fun bindMainView(activity: MainActivity): MainView
}