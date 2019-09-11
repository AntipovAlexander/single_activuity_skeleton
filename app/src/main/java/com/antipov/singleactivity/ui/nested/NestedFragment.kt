package com.antipov.singleactivity.ui.nested

import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject

class NestedFragment : BaseFragment(), NestedView {

    @Inject
    @field:HostNavigator
    lateinit var navigator: AppNavigator

    @Inject
    @InjectPresenter
    lateinit var presenter: NestedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutRes: Int = R.layout.nested_fragment

    override fun getActivityNavigator(): AppNavigator = navigator
}