package com.antipov.singleactivity.ui.first_flow

import android.support.v7.app.AppCompatActivity
import com.antipov.singleactivity.R
import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.di.scopes.PerFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.nested.NestedFragment
import com.antipov.singleactivity.ui.nested.NestedModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Router

@Module
abstract class FirstFlowModule {

    @PerChildFragment
    @ContributesAndroidInjector(modules = [NestedModule::class])
    abstract fun nestedInjectorInjector(): NestedFragment

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
        fun providePresenter(router: Router) = FirstFlowPresenter(router)
    }
}