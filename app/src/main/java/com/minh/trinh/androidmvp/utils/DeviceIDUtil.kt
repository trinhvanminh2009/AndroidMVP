package com.minh.trinh.androidmvp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

class DeviceIDUtil {
    companion object{
        @SuppressLint("HardwareIds")
        fun getDeviceID(context: Context):String = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }
}