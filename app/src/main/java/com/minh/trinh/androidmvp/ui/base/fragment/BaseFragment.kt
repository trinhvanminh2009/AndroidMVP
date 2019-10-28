package com.minh.trinh.androidmvp.ui.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseActivity
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseView
import com.minh.trinh.androidmvp.ui.base.activity.view.DebouncedOnClickListener
import com.minh.trinh.androidmvp.ui.base.activity.view.OnClickView
import com.minh.trinh.androidmvp.utils.ApiConstants
import dagger.android.DaggerFragment

abstract class BaseFragment : DaggerFragment() , BaseView{

    private var activity: BaseActivity? = null


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateView(view!!)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?  = inflater!!.inflate(getLayoutFragment(), container,false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity){
            this.activity = context
        }
    }

    protected abstract fun updateView(view: View)

    @LayoutRes
    protected abstract fun getLayoutFragment(): Int


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