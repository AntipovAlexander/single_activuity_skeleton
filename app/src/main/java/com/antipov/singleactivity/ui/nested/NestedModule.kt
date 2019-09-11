package com.antipov.singleactivity.ui.nested

import com.antipov.singleactivity.di.scopes.PerChildFragment
import dagger.Module
import dagger.Provides

@Module
abstract class NestedModule {

    @Module
    companion object {
        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter() = NestedPresenter()
    }
}