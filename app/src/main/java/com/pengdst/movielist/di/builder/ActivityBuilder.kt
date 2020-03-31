package com.pengdst.movielist.di.builder

import com.pengdst.movielist.di.module.MainModule
import com.pengdst.movielist.di.scope.Presentation
import com.pengdst.movielist.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}