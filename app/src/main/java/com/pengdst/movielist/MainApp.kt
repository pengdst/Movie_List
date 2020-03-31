package com.pengdst.movielist

import com.pengdst.movielist.di.component.ApplicationComponent
import dagger.android.AndroidInjection.inject
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return ApplicationComponent.create().apply{ inject(this@MainApp) }
    }
}