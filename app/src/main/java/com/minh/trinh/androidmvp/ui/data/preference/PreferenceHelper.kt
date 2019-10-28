package com.minh.trinh.androidmvp.ui.data.preference

import com.minh.trinh.androidmvp.ui.data.remote.response.ProfileResponse

interface PreferenceHelper {
    fun getAccessToken(): String?
    fun setAccessToken(accessToken: String?)

    fun saveProfileResponse(profileResponse : ProfileResponse)
    fun updateProfileUser()
    fun clearAllData()
}