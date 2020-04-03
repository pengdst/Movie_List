package com.pengdst.movielist.di.module

import androidx.lifecycle.ViewModel
import com.pengdst.movielist.datas.routes.MovieRoute
import com.pengdst.movielist.di.scope.ViewModelKey
import com.pengdst.movielist.presentation.MainActivity
import com.pengdst.movielist.presentation.mvvm.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class MainModule {

    @Module
    companion object{

        @JvmStatic
        @Provides
        fun provideMovieRoute(retrofit: Retrofit): MovieRoute =
            retrofit.create(MovieRoute::class.java)

    }

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}