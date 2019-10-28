package com.minh.trinh.androidmvp.ui.services

import android.content.Intent
import android.content.SharedPreferences
import android.util.AndroidException
import androidx.core.app.JobIntentService
import com.minh.trinh.androidmvp.ui.data.preference.PreferenceHelper
import com.minh.trinh.androidmvp.ui.data.remote.AppServices
import com.minh.trinh.androidmvp.ui.evenbus.EventFetchProfileSuccess
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class FetchProfileService : JobIntentService() {

    @Inject
    lateinit var appServices: AppServices

    @Inject
    lateinit var preferences: PreferenceHelper


    private var disposable: Disposable? = null
    override fun onHandleWork(intent: Intent) {
        disposable = appServices.getUserProfile()
            .subscribe { response-> preferences.saveProfileResponse(response)
                         EventBus.getDefault().post(EventFetchProfileSuccess(response)) }
    }

    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()

    }

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }
}