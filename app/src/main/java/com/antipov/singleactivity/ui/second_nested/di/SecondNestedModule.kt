package com.antipov.singleactivity.ui.second_nested.di

import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.ui.second_nested.SecondNestedPresenter
import dagger.Module
import dagger.Provides

@Module
abstract class SecondNestedModule {

    @Module
    companion object {
        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter() = SecondNestedPresenter()
    }
}