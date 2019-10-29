package com.minh.trinh.androidmvp.ui.feature.welcome

import com.minh.trinh.androidmvp.di.scope.ActivityScope
import com.minh.trinh.androidmvp.ui.feature.welcome.interactor.WelcomeInteractor
import com.minh.trinh.androidmvp.ui.feature.welcome.interactor.WelcomeInteractorImpl
import com.minh.trinh.androidmvp.ui.feature.welcome.presenter.WelcomePresenter
import com.minh.trinh.androidmvp.ui.feature.welcome.presenter.WelcomePresenterImpl
import com.minh.trinh.androidmvp.ui.feature.welcome.view.WelcomeView
import dagger.Binds
import dagger.Module

@Module
abstract class WelcomeModule {
    @Binds
    @ActivityScope
    abstract fun providerWelcomeInteractor(interactor: WelcomeInteractorImpl): WelcomeInteractor

    @Binds
    @ActivityScope
    abstract fun providerWelcomePresenter(presenter: WelcomePresenterImpl<WelcomeView, WelcomeInteractor>)
            : WelcomePresenter<WelcomeView, WelcomeInteractor>
}