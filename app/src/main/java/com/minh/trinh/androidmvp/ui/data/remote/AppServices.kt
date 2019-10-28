package com.minh.trinh.androidmvp.ui.data.remote

import com.minh.trinh.androidmvp.ui.data.remote.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.GET
import java.io.File

interface AppServices {


    @GET("account/profile.fetch")
    fun getUserProfile(): Single<ProfileResponse>



    companion object{
        private var instance: AppServices? = null
        var version: String = "0.0.0"
        var isEmulator: String = "false"
        lateinit var cacheDir: File
    }
}