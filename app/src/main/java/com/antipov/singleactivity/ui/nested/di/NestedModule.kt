package com.antipov.singleactivity.ui.nested.di

import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.ui.nested.NestedPresenter
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