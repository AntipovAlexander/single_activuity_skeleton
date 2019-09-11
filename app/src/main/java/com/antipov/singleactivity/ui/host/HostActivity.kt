package com.antipov.singleactivity.ui.host

import android.os.Bundle
import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseActivity
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.antipov.singleactivity.utils.util.HostDependency
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

    @Inject
    lateinit var hostDependency: HostDependency

    override val layoutRes = R.layout.activity_host

    override fun getActivityNavigator() = navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hostDependency.value = "This value set in host activity"
    }
}
