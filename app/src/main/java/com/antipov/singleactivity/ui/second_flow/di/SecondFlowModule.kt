package com.antipov.singleactivity.ui.second_flow.di

import android.support.v7.app.AppCompatActivity
import com.antipov.singleactivity.R
import com.antipov.singleactivity.di.scopes.PerFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.second_flow.SecondFlowFragment
import com.antipov.singleactivity.ui.second_flow.SecondFlowPresenter
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
abstract class SecondFlowModule {

    @Module
    companion object {

        @Provides
        @PerFragment
        @JvmStatic
        @SecondFlowNavigator
        fun provideSecondFlowNav(flowFragment: SecondFlowFragment) =
            AppNavigator(
                flowFragment.activity as AppCompatActivity,
                flowFragment.childFragmentManager,
                R.id.secondFlowContainer
            )

        @Provides
        @PerFragment
        @JvmStatic
        fun providePresenter(router: Router) =
            SecondFlowPresenter(router)

        @Provides
        @PerFragment
        @JvmStatic
        fun provideHostDependency() = FirstFlowDependency()
    }
}