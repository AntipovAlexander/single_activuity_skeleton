package com.antipov.singleactivity.ui.second_nested.di

import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.ui.second_nested.SecondNestedPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
abstract class SecondNestedModule {

    @Module
    companion object {
        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter(router: Router) = SecondNestedPresenter(router)
    }
}