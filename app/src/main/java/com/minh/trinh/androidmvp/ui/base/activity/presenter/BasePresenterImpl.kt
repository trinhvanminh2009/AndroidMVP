package com.minh.trinh.androidmvp.ui.base.activity.presenter

import com.minh.trinh.androidmvp.R
import com.minh.trinh.androidmvp.ui.base.activity.interactor.BaseInteractor
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseView
import com.minh.trinh.androidmvp.ui.data.remote.config.NetworkConnectionInterceptor
import com.minh.trinh.androidmvp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

abstract class BasePresenterImpl<V : BaseView, I : BaseInteractor>
constructor(
    var interactor: I?,
    val scheduleProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : BasePresenter<V, I> {

    var view: V? = null
        private set

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }


    override fun handleError(t: Throwable) {
        when (t) {
            is HttpException -> handleHttpException(t)
            is NetworkConnectionInterceptor.NoConnectivityException -> view?.showError(R.string.internet_failed)
            is SocketTimeoutException -> view?.showError(R.string.connection_timeout)
            else -> {
                if (t !is NetworkConnectionInterceptor.NoConnectivityException) {
                    view?.showError(R.string.connection_failed)
                }
            }
        }
    }

    override fun handleHttpException(t: HttpException) {
        when (t.code()) {
            HttpURLConnection.HTTP_INTERNAL_ERROR -> {
                try {
                    view?.showError(R.string.no_connection)
                } catch (e: Exception) {
                    view?.showError(R.string.connection_failed)
                }
            }
        }
    }

    override fun handleResponseError(msg: String, customCode: Int) {
        view?.showError(msg)
    }
}