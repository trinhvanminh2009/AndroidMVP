package com.minh.trinh.androidmvp.di.builder

import com.minh.trinh.androidmvp.ui.services.FetchProfileService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilder {
    @ContributesAndroidInjector
    abstract fun bindFetchProfileService() : FetchProfileService
}