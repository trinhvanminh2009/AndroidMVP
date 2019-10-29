package com.minh.trinh.androidmvp.di.builder

import com.minh.trinh.androidmvp.di.scope.ActivityScope
import com.minh.trinh.androidmvp.ui.feature.welcome.WelcomeModule
import com.minh.trinh.androidmvp.ui.feature.welcome.view.WelcomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [WelcomeModule::class])
    abstract fun bindWelcomeActivity(): WelcomeActivity

}