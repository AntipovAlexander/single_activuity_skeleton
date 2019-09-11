package com.antipov.singleactivity.ui.nested

import android.os.Bundle
import android.view.View
import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import com.antipov.singleactivity.utils.util.HostDependency
import com.antipov.singleactivity.utils.util.SingletonDependency
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.nested_fragment.*
import javax.inject.Inject

class NestedFragment : BaseFragment(), NestedView {

    @Inject
    @field:HostNavigator
    lateinit var navigator: AppNavigator

    @Inject
    @InjectPresenter
    lateinit var presenter: NestedPresenter

    @Inject
    lateinit var firstFlowDependency: FirstFlowDependency

    @Inject
    lateinit var hostDependency: HostDependency

    @Inject
    lateinit var singletonDependency: SingletonDependency

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var singleton: SingletonDependency

    override val layoutRes: Int = R.layout.nested_fragment

    override fun getActivityNavigator(): AppNavigator = navigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstNestedTv2.text = firstFlowDependency.value
        firstNestedTv3.text = hostDependency.value
        firstNestedTv4.text = singletonDependency.value
    }
}