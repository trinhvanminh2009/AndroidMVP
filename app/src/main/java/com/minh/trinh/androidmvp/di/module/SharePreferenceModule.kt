package com.minh.trinh.androidmvp.di.module

import com.minh.trinh.androidmvp.ui.data.preference.AppPreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharePreferenceModule {
    @Provides
    @Singleton
    fun providePreferenceHelper(appPreferenceHelper: AppPreferenceHelper): AppPreferenceHelper = appPreferenceHelper
}