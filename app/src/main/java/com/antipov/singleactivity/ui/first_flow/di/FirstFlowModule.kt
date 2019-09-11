package com.antipov.singleactivity.ui.first_flow.di

import android.support.v7.app.AppCompatActivity
import com.antipov.singleactivity.R
import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.di.scopes.PerFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.first_flow.FirstFlowFragment
import com.antipov.singleactivity.ui.first_flow.FirstFlowPresenter
import com.antipov.singleactivity.ui.first_nested.FirstNestedFragment
import com.antipov.singleactivity.ui.first_nested.di.FirstNestedModule
import com.antipov.singleactivity.ui.second_nested.SecondNestedFragment
import com.antipov.singleactivity.ui.second_nested.di.SecondNestedModule
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Router

@Module
abstract class FirstFlowModule {

    @PerChildFragment
    @ContributesAndroidInjector(modules = [FirstNestedModule::class])
    abstract fun nestedInjectorInjector(): FirstNestedFragment

    @PerChildFragment
    @ContributesAndroidInjector(modules = [SecondNestedModule::class])
    abstract fun secondNestedInjectorInjector(): SecondNestedFragment

    @Module
    companion object {

        @Provides
        @PerFragment
        @JvmStatic
        @FirstFlowNavigator
        fun provideFirstFlowNav(flowFragment: FirstFlowFragment) =
            AppNavigator(
                flowFragment.activity as AppCompatActivity,
                flowFragment.childFragmentManager,
                R.id.firstFlowContainer
            )

        @Provides
        @PerFragment
        @JvmStatic
        fun providePresenter(router: Router) =
            FirstFlowPresenter(router)

        @Provides
        @PerFragment
        @JvmStatic
        fun provideHostDependency() = FirstFlowDependency()
    }
}