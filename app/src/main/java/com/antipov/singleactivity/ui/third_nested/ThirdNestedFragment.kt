package com.antipov.singleactivity.ui.third_nested

import android.os.Bundle
import android.view.View
import com.antipov.singleactivity.R
import com.antipov.singleactivity.di.NestedNavigator
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.antipov.singleactivity.ui.host.di.HostNavigator
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import com.antipov.singleactivity.utils.util.HostDependency
import com.antipov.singleactivity.utils.util.SingletonDependency
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.third_nested_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class ThirdNestedFragment : BaseFragment(), ThirdNestedView {

    @Inject
    @field:HostNavigator
    lateinit var navigator: AppNavigator

    @Inject
    @field:NestedNavigator
    lateinit var nestedNavigator: AppNavigator

    @Inject
    @InjectPresenter
    lateinit var presenter: ThirdNestedPresenter

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

    override val layoutRes: Int = R.layout.third_nested_fragment

    override fun getActivityNavigator(): AppNavigator = navigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thirdNestedTv2.text = firstFlowDependency.value
        thirdNestedTv3.text = hostDependency.value
        thirdNestedTv4.text = singletonDependency.value
        thirdNestedBtn.onClick { presenter.goNextFlow() }
    }

    override fun onBackPressed() {
        navigatorHolder.setNavigator(nestedNavigator)
        presenter.onBackPressed()
    }
}