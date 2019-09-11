package com.antipov.singleactivity.ui.second_flow

import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.antipov.singleactivity.ui.second_flow.di.SecondFlowNavigator
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject

class SecondFlowFragment : BaseFragment(), SecondFlowView {

    @Inject
    @InjectPresenter
    lateinit var presenter: SecondFlowPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    @field:HostNavigator
    lateinit var navigator: AppNavigator

    override val layoutRes: Int = R.layout.second_flow_fragment

    override fun getActivityNavigator() = navigator

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.goBack()
    }
}