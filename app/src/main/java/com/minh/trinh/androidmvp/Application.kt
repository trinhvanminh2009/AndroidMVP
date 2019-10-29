package com.minh.trinh.androidmvp

import com.minh.trinh.androidmvp.di.component.ApplicationComponent
import com.minh.trinh.androidmvp.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class Application : DaggerApplication() {
    private lateinit var applicationComponent: ApplicationComponent


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()



        return applicationComponent
    }



    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)

    }

}