package com.antipov.singleactivity.di

import com.antipov.singleactivity.di.scopes.PerActivity
import com.antipov.singleactivity.ui.host.HostActivity
import com.antipov.singleactivity.ui.host.HostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplicationModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [HostModule::class])
    abstract fun bindHost(): HostActivity
}