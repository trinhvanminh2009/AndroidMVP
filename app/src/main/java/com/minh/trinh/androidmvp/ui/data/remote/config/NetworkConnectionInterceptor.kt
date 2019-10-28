package com.minh.trinh.androidmvp.ui.data.remote.config

import android.content.Context
import com.minh.trinh.androidmvp.R
import com.minh.trinh.androidmvp.utils.InternetUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val context: Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        if (!InternetUtil.isConnectedToInternet(context)) {
            throw NoConnectivityException(context.getString(R.string.no_connection))
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    class NoConnectivityException(message: String) : IOException(message)

}