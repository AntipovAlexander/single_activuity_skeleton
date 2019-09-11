package com.antipov.singleactivity.ui.first_nested.di

import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.ui.first_nested.FirstNestedPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
abstract class FirstNestedModule {

    @Module
    companion object {
        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter(router: Router) = FirstNestedPresenter(router)
    }
}