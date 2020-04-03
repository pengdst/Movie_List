package com.pengdst.movielist.di.builder

import androidx.lifecycle.ViewModelProvider
import com.pengdst.movielist.di.module.MainModule
import com.pengdst.movielist.di.scope.Presentation
import com.pengdst.movielist.di.factory.ViewModelFactory
import com.pengdst.movielist.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Presentation
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}