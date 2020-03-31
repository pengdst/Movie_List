package com.pengdst.movielist.di.module

import com.pengdst.movielist.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun connect(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
                baseUrl(BuildConfig.BASE_URL)
                client(client)
                addConverterFactory(GsonConverterFactory.create())
            }.build()
    }

    @Provides
    @Singleton
    fun httpClient(interceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(interceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun httpInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG){
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}