package com.antipov.singleactivity.ui.host

import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseActivity
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject

class HostActivity : BaseActivity(), HostView {

    @Inject
    @InjectPresenter
    lateinit var presenter: HostPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    @field:HostNavigator
    lateinit var navigator: AppNavigator

    override val layoutRes = R.layout.activity_host

    override fun getActivityNavigator() = navigator
}
