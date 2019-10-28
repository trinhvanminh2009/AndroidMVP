package com.minh.trinh.androidmvp.ui.base.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

abstract class BaseItemResponse<Item : Any> {

    @SerializedName("item")
    @Expose
    lateinit var item: Item
}