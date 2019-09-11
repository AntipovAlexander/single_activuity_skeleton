package com.antipov.singleactivity.ui.host

import com.antipov.singleactivity.R
import com.antipov.singleactivity.di.scopes.PerActivity
import com.antipov.singleactivity.di.scopes.PerFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.first_flow.FirstFlowFragment
import com.antipov.singleactivity.ui.first_flow.FirstFlowModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Router
import javax.inject.Named

@Module
abstract class HostModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [FirstFlowModule::class])
    abstract fun mainFragmentInjector(): FirstFlowFragment

    @Module
    companion object {
        @Provides
        @PerActivity
        @JvmStatic
        fun providePresenter(router: Router) = HostPresenter(router)

        @Provides
        @PerActivity
        @JvmStatic
        @Named("host_navigator")
        fun provideMainActivityNavigator(hostActivity: HostActivity) = AppNavigator(hostActivity, R.id.hostContainer)
    }
}