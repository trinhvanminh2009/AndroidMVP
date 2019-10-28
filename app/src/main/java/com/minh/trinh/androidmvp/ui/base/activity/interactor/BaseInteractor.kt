package com.minh.trinh.androidmvp.ui.base.activity.interactor

interface BaseInteractor {
    fun getAccessToken(): String?
    fun setAccessToken(accessToken: String)
    fun updateProfileUser()
}