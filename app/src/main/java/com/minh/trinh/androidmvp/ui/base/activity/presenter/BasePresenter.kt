package com.minh.trinh.androidmvp.ui.base.activity.presenter

import com.minh.trinh.androidmvp.ui.base.activity.interactor.BaseInteractor
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseView
import retrofit2.HttpException

interface BasePresenter<V: BaseView, I: BaseInteractor> {
    fun onAttach(view: V)
    fun onDetach()
    fun handleError(t: Throwable)
    fun handleHttpException(t: HttpException)
    fun handleResponseError(msg: String, customCode: Int)
}