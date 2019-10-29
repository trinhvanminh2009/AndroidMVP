package com.minh.trinh.androidmvp.ui.feature.welcome.interactor

import com.minh.trinh.androidmvp.ui.base.activity.interactor.BaseInteractorImpl
import com.minh.trinh.androidmvp.ui.data.preference.PreferenceHelper
import com.minh.trinh.androidmvp.ui.data.remote.AppServices
import javax.inject.Inject

class WelcomeInteractorImpl @Inject internal  constructor(preferenceHelper: PreferenceHelper, apiHelper : AppServices)
    : BaseInteractorImpl( preferenceHelper, apiHelper), WelcomeInteractor