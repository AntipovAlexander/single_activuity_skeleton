package com.antipov.singleactivity.ui.host

import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Named

class HostActivity : BaseActivity(), HostView {

    @Inject
    @InjectPresenter
    lateinit var presenter: HostPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    @field:Named("host_navigator")
    lateinit var navigator: AppNavigator

    override val layoutRes = R.layout.activity_host

    override fun getActivityNavigator() = navigator
}
