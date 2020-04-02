package com.pengdst.movielist.di.module

import com.pengdst.movielist.datas.routes.MovieRoute
import com.pengdst.movielist.presentation.MainActivity
import com.pengdst.movielist.presentation.mvvm.MainViewModel
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
        fun provideMainViewModel(
            movieRoute: MovieRoute
        ): MainViewModel = MainViewModel(movieRoute)
    }

    @Binds
    abstract fun bindMainViewModel(activity: MainActivity): MainViewModel
}