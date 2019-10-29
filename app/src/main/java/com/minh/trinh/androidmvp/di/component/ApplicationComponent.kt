package com.minh.trinh.androidmvp.di.component

import com.minh.trinh.androidmvp.Application
import com.minh.trinh.androidmvp.di.builder.ActivityBuilder
import com.minh.trinh.androidmvp.di.builder.ServiceBuilder
import com.minh.trinh.androidmvp.di.module.ApiModule
import com.minh.trinh.androidmvp.di.module.ApplicationModule
import com.minh.trinh.androidmvp.di.module.SharePreferenceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ApiModule::class,
        SharePreferenceModule::class,
        ServiceBuilder :: class,
        ActivityBuilder:: class
    ])
interface ApplicationComponent : AndroidInjector<Application> {
    override fun inject(instance: Application?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}