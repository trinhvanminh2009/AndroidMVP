package com.minh.trinh.androidmvp.ui.data.preference

import android.content.Context
import android.content.SharedPreferences
import com.minh.trinh.androidmvp.di.qualifier.ApplicationContext
import com.minh.trinh.androidmvp.ui.data.remote.response.ProfileResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferenceHelper
@Inject constructor(@ApplicationContext private val context: Context):PreferenceHelper{

    private var preference : SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    override fun getAccessToken(): String? = preference.getString(ACCESS_TOKEN,null)

    override fun setAccessToken(accessToken: String?) {
        preference.edit().putString(ACCESS_TOKEN, accessToken).apply()
    }

    override fun updateProfileUser() {

    }

    override fun clearAllData() {
        preference.edit().clear().apply()
    }


    override fun saveProfileResponse(profileResponse: ProfileResponse) {
        with(profileResponse.data.item){
            preference.edit().putString(USER_NAME, name)
                .putInt(MY_USER_ID, id)
                .putString(MOBILE_PHONE, mobile)

        }
    }

    companion object{
        const val PREF_NAME = "MVPPreference"
        const val TOKEN_FIREBASE = "token_firebase"
        // user info
        // -------------------------------------------------
        const val ACCESS_TOKEN = "access_token"
        const val USER_NAME = "user_name"
        const val MY_USER_ID = "uid"
        const val MOBILE_PHONE = "mobile_phone"
        const val MY_FLOWER = "num_flower"
        const val AVATAR = "avatar_link"
        const val GENDER = "gender"
        const val IS_UPDATE_AVATAR = "is_update_avatar"
        const val IS_PASSWORD = "is_password"
        const val CITY_SHORT_NAME = "city_short_name"
        const val LOCATION = "location"
        const val LOCATION_ID = "location_id"
        const val ABOUT_ME = "about_me"

    }
}
