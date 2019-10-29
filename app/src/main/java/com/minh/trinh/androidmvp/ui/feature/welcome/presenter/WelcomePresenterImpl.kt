package com.minh.trinh.androidmvp.ui.feature.welcome.presenter

import com.minh.trinh.androidmvp.ui.base.activity.presenter.BasePresenterImpl
import com.minh.trinh.androidmvp.ui.feature.welcome.interactor.WelcomeInteractor
import com.minh.trinh.androidmvp.ui.feature.welcome.view.WelcomeView
import com.minh.trinh.androidmvp.utils.ApiConstants.Companion.WELCOME_SCREEN_TIME
import com.minh.trinh.androidmvp.utils.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WelcomePresenterImpl<V : WelcomeView, I : WelcomeInteractor>
@Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenterImpl<V, I>(interactor, schedulerProvider, compositeDisposable),
    WelcomePresenter<V, I> {

    override fun decideNextPage() {
        Observable.timer(WELCOME_SCREEN_TIME, TimeUnit.MILLISECONDS)
            .subscribeOn(scheduleProvider.io())
            .observeOn(scheduleProvider.ui())
            .subscribe {
                interactor?.let {
                    when {
                        it.getAccessToken() != null -> {
                            it.updateProfileUser()
                            view?.gotoLoginPage()
                        }
                        else -> view?.gotoMainPage()
                    }
                }
            }.let { d -> compositeDisposable.add(d) }
    }

}