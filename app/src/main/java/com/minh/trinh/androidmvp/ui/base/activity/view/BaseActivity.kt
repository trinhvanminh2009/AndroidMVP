package com.minh.trinh.androidmvp.ui.base.activity.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.annotation.LayoutRes
import com.minh.trinh.androidmvp.R
import com.minh.trinh.androidmvp.utils.ApiConstants.Companion.MINIMUM_INTERVAL_CLICK_TIME
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        getLayoutActivity()?.let {
            setContentView(it)
        }
        updateView()
    }

    abstract fun updateView()

    @LayoutRes
    abstract fun getLayoutActivity(): Int?

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransitionEnter()
    }

    override fun finish() {
        super.finish()
        overridePendingTransitionExit()
    }

    override fun showError(message: String, title: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(resId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuccessMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showOfflineDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    private fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_to_left, R.anim.slide_from_right)
    }

    fun setEventClick(list: List<View>, listenerOnClickView: OnClickView) {
        list.forEach {
            it.setOnClickListener(object : DebouncedOnClickListener(MINIMUM_INTERVAL_CLICK_TIME) {
                override fun onDebouncedClick(v: View) {
                    listenerOnClickView.eventClick(v)
                }
            })
        }
    }
}