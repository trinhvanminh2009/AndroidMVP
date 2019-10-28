package com.minh.trinh.androidmvp.ui.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.minh.trinh.androidmvp.R
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseActivity
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseView
import com.minh.trinh.androidmvp.ui.base.activity.view.DebouncedOnClickListener
import com.minh.trinh.androidmvp.ui.base.activity.view.OnClickView
import com.minh.trinh.androidmvp.utils.ApiConstants

abstract class BaseDialogFragment : DialogFragment(), BaseView {

    private var activity: BaseActivity? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.PopupFullscreen)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getDialogFragmentLayoutRes(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.activity = context
        }
    }

    abstract fun updateView()

    @LayoutRes
    abstract fun getDialogFragmentLayoutRes(): Int


    fun setEventClick(list: List<View>, listenerOnClickView: OnClickView) {
        list.forEach {
            it.setOnClickListener(object : DebouncedOnClickListener(ApiConstants.MINIMUM_INTERVAL_CLICK_TIME) {
                override fun onDebouncedClick(v: View) {
                    listenerOnClickView.eventClick(v)
                }
            })
        }
    }

    override fun showError(message: String, title: String?) {
        activity?.showError(message, title)
    }

    override fun showError(resId: Int) {
        activity?.showError(resId)
    }

    override fun showSuccessMessage(message: String) {
        activity?.showSuccessMessage(message)
    }

    override fun showOfflineDialog() {
        activity?.showOfflineDialog()
    }

    override fun showLoadingDialog() {
        activity?.showLoadingDialog()
    }

    override fun hideLoadingDialog() {
        activity?.hideLoadingDialog()
    }
}