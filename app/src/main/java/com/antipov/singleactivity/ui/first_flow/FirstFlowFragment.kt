package com.antipov.singleactivity.ui.first_flow

import android.os.Bundle
import android.view.View
import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.first_flow.di.FirstFlowNavigator
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
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

    @Inject
    lateinit var firstFlowDependency: FirstFlowDependency

    private val currentFragment: BaseFragment?
        get() = childFragmentManager.findFragmentById(R.id.firstFlowContainer) as? BaseFragment

    override val layoutRes: Int = R.layout.first_flow_fragment

    override fun getActivityNavigator() = navigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstFlowDependency.value = "This value set in FirstFlow"
        presenter.onViewCreated()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.post { if (childFragmentManager.findFragmentById(R.id.firstFlowContainer) == null) presenter.enterNested() }
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed()
    }
}