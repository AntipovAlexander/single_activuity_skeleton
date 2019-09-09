package com.antipov.singleactivity.ui.nested

import android.support.v4.app.Fragment
import com.antipov.singleactivity.di.scopes.PerChildFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class NestedModule {

    @Module
    companion object {
        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter() = NestedPresenter()
    }

    @Binds
    @PerChildFragment
    @Named("nested")
    internal abstract fun activity(nestedFragment: Fragment): Fragment
}