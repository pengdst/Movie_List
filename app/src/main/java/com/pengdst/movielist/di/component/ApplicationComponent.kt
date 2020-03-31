package com.pengdst.movielist.di.component

import com.pengdst.movielist.MainApp
import com.pengdst.movielist.di.builder.ActivityBuilder
import com.pengdst.movielist.di.module.RetrofitModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    RetrofitModule::class,
    ActivityBuilder::class
])
interface ApplicationComponent : AndroidInjector<MainApp>