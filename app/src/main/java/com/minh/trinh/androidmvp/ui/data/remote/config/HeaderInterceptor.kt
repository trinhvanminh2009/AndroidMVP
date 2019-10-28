package com.minh.trinh.androidmvp.ui.data.remote.config

import android.content.Context
import com.minh.trinh.androidmvp.ui.data.preference.PreferenceHelper
import com.minh.trinh.androidmvp.ui.data.remote.AppServices.Companion.isEmulator
import com.minh.trinh.androidmvp.ui.data.remote.AppServices.Companion.version
import com.minh.trinh.androidmvp.utils.ApiConstants
import com.minh.trinh.androidmvp.utils.DeviceIDUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class HeaderInterceptor(private val context: Context, private val preferenceHelper: PreferenceHelper):Interceptor {

    companion object {
        const val USER_AGENT = "User-Agent"
        const val TIME_ZONE = "time_zone"
        const val LOCALE = "locale"
        const val IS_EMULATOR = "is_emulator"
        const val HEADER_VERSION = "version"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = preferenceHelper.getAccessToken()
        val deviceId = DeviceIDUtil.getDeviceID(context)

        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .addHeader(USER_AGENT, System.getProperty("http.agent")!!)
            .addHeader(ApiConstants.DEVICE_ID, deviceId)
            .addHeader(TIME_ZONE, TimeZone.getDefault().id)
            .addHeader(LOCALE, Locale.getDefault().language)
            .addHeader(IS_EMULATOR, isEmulator)
            .addHeader(HEADER_VERSION, version)
        if (accessToken != null) {
            requestBuilder.addHeader(ApiConstants.ACCESS_TOKEN, accessToken)
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}