package com.antipov.singleactivity.ui.nested

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.antipov.singleactivity.R
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Named

class NestedFragment : Fragment(), NestedView {

//    @Inject
//    @field:Named("first_flow_navigator")
//    lateinit var navigator: AppNavigator

//    @Inject
//    @InjectPresenter
//    lateinit var presenter: NestedPresenter

//    @ProvidePresenter
//    fun providePresenter() = presenter

//    override val layoutRes: Int = R.layout.nested_fragment
//
//    override fun getActivityNavigator(): AppNavigator = navigator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.nested_fragment, container, false)
}