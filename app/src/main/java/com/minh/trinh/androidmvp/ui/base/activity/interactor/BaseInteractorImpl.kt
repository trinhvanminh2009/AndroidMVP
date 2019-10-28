package com.minh.trinh.androidmvp.ui.base.activity.interactor

import com.minh.trinh.androidmvp.ui.data.preference.PreferenceHelper
import com.minh.trinh.androidmvp.ui.data.remote.AppServices

class BaseInteractorImpl(val preferenceHelper: PreferenceHelper, val apiHelper: AppServices): BaseInteractor {

    override fun getAccessToken(): String? = preferenceHelper.getAccessToken()

    override fun setAccessToken(accessToken: String) {
        preferenceHelper.setAccessToken(accessToken)
    }

    override fun updateProfileUser() {
       apiHelper.getUserProfile()
    }
}