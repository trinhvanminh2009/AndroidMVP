package com.minh.trinh.androidmvp.ui.feature.welcome.view

import com.minh.trinh.androidmvp.ui.MainActivity
import com.minh.trinh.androidmvp.ui.base.activity.view.BaseActivity
import com.minh.trinh.androidmvp.ui.feature.welcome.interactor.WelcomeInteractor
import com.minh.trinh.androidmvp.ui.feature.welcome.presenter.WelcomePresenter
import com.minh.trinh.androidmvp.utils.extension.launchActivity
import javax.inject.Inject

class WelcomeActivity : BaseActivity(), WelcomeView {

    @Inject
    lateinit var presenter: WelcomePresenter<WelcomeView, WelcomeInteractor>

    override fun getLayoutActivity(): Int? = null

    override fun updateView() {
        presenter.onAttach(this)
        presenter.decideNextPage()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun gotoMainPage() {
        finish()
        launchActivity<MainActivity>()
    }

    override fun gotoLoginPage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onForceUpdate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNoForceUpdate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
