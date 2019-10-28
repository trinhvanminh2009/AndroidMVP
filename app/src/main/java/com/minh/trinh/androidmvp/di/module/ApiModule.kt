package com.minh.trinh.androidmvp.di.module

import android.app.Application
import com.minh.trinh.androidmvp.ui.data.preference.PreferenceHelper
import com.minh.trinh.androidmvp.ui.data.remote.config.HeaderInterceptor
import com.minh.trinh.androidmvp.ui.data.remote.config.NetworkConnectionInterceptor
import com.minh.trinh.androidmvp.utils.ApiConstants.Companion.TIME_OUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideHttpClient(application: Application, preferenceHelper: PreferenceHelper): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(NetworkConnectionInterceptor(application))
            .addInterceptor(HeaderInterceptor(application, preferenceHelper))
            .addInterceptor(interceptor)
            .build()
    }
}