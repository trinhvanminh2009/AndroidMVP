package com.minh.trinh.androidmvp.ui.base.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

abstract class BaseDataResponse<Data : Any> {
    @SerializedName("data")
    @Expose
    lateinit var data: Data

    @SerializedName("Status")
    @Expose
    var status: Boolean = false

}