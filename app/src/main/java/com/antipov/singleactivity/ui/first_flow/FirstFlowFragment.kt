package com.antipov.singleactivity.ui.first_flow

import android.os.Bundle
import android.view.View
import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.first_flow.di.FirstFlowNavigator
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.first_flow_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class FirstFlowFragment : BaseFragment(), FirstFlowView {

    @Inject
    @InjectPresenter
    lateinit var presenter: FirstFlowPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    @field:FirstFlowNavigator
    lateinit var navigator: AppNavigator

    override val layoutRes: Int = R.layout.first_flow_fragment

    override fun getActivityNavigator() = navigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openNested.onClick { presenter.enterNested() }
    }

    override fun onResume() {
        super.onResume()
        getActivityNavigator()
    }
}