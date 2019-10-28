package com.minh.trinh.androidmvp.ui.base.activity.view

import androidx.annotation.StringRes

interface BaseView {
    fun showError(message: String, title: String? = null)

    fun showError(@StringRes resId: Int)

    fun showSuccessMessage(message: String)

    fun showOfflineDialog()

    fun showLoadingDialog()

    fun hideLoadingDialog()
}