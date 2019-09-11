package com.antipov.singleactivity.ui.host.di

import com.antipov.singleactivity.R
import com.antipov.singleactivity.di.scopes.PerActivity
import com.antipov.singleactivity.di.scopes.PerFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.first_flow.FirstFlowFragment
import com.antipov.singleactivity.ui.first_flow.di.FirstFlowModule
import com.antipov.singleactivity.ui.host.HostActivity
import com.antipov.singleactivity.ui.host.HostPresenter
import com.antipov.singleactivity.ui.second_flow.SecondFlowFragment
import com.antipov.singleactivity.ui.second_flow.di.SecondFlowModule
import com.antipov.singleactivity.utils.util.HostDependency
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Router

@Module
abstract class HostModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [FirstFlowModule::class])
    abstract fun firstFragment(): FirstFlowFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [SecondFlowModule::class])
    abstract fun secondFragment(): SecondFlowFragment

    @Module
    companion object {
        @Provides
        @PerActivity
        @JvmStatic
        fun providePresenter(router: Router) =
            HostPresenter(router)

        @Provides
        @PerActivity
        @JvmStatic
        @HostNavigator
        fun provideMainActivityNavigator(hostActivity: HostActivity) =
            AppNavigator(hostActivity, R.id.hostContainer)

        @Provides
        @PerActivity
        @JvmStatic
        fun provideHostDependency(hostActivity: HostActivity) = HostDependency()
    }
}