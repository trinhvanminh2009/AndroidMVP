package com.minh.trinh.androidmvp.ui.data.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("gender")
    val gender: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("mobile")
    val mobile: String,

    @SerializedName("about")
    val about: String,

    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("verified_email")
    private val verifiedEmail: Boolean,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("id")
    val id: Int

)