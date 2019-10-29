package com.minh.trinh.androidmvp.ui.feature.welcome.presenter

import com.minh.trinh.androidmvp.ui.base.activity.presenter.BasePresenter
import com.minh.trinh.androidmvp.ui.feature.welcome.interactor.WelcomeInteractor
import com.minh.trinh.androidmvp.ui.feature.welcome.view.WelcomeView

interface WelcomePresenter<V: WelcomeView, I: WelcomeInteractor> : BasePresenter<V,I> {
    fun decideNextPage()
}