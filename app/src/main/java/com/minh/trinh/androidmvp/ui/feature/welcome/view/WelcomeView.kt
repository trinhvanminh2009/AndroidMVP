package com.minh.trinh.androidmvp.ui.feature.welcome.view

import com.minh.trinh.androidmvp.ui.base.activity.view.BaseView

interface WelcomeView : BaseView{
    fun gotoMainPage()
    fun gotoLoginPage()

    fun onForceUpdate()
    fun onNoForceUpdate()
}