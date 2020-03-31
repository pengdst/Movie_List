package com.pengdst.movielist.di.module

import com.pengdst.movielist.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    fun connect():Retrofit {
        return Retrofit.Builder().apply {
                baseUrl(BuildConfig.BASE_URL)
                client(httpClient())
                addConverterFactory(GsonConverterFactory.create())
            }.build();
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(ConstantHelpers.BASE_URL)
//            .build();
    }

    private fun httpClient():OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(httpInterceptor())
        }.build()
    }

    private fun httpInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG){
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}