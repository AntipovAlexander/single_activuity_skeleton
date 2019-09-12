package com.antipov.singleactivity.ui.first_nested

import android.os.Bundle
import android.view.View
import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.first_flow.di.FirstFlowNavigator
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import com.antipov.singleactivity.utils.util.HostDependency
import com.antipov.singleactivity.utils.util.SingletonDependency
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.nested_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class FirstNestedFragment : BaseFragment(), FirstNestedView {

    @Inject
    @field:FirstFlowNavigator
    lateinit var navigator: AppNavigator

    @Inject
    @field:HostNavigator
    lateinit var hostNavigator: AppNavigator

    @Inject
    @InjectPresenter
    lateinit var presenter: FirstNestedPresenter

    @Inject
    lateinit var firstFlowDependency: FirstFlowDependency

    @Inject
    lateinit var hostDependency: HostDependency

    @Inject
    lateinit var singletonDependency: SingletonDependency

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutRes: Int = R.layout.nested_fragment

    override fun getActivityNavigator(): AppNavigator = navigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstNestedTv2.text = firstFlowDependency.value
        firstNestedTv3.text = hostDependency.value
        firstNestedTv4.text = singletonDependency.value
        firstNestedBtn.onClick { presenter.goNext()}
    }

    override fun onBackPressed() {
        navigatorHolder.setNavigator(hostNavigator)
        presenter.onBackPressed()
    }
}