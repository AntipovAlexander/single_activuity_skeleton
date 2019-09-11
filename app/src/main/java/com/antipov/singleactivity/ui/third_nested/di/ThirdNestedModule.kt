package com.antipov.singleactivity.ui.third_nested.di

import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.ui.third_nested.ThirdNestedPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
abstract class ThirdNestedModule {

    @Module
    companion object {
        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter(router: Router) = ThirdNestedPresenter(router)
    }
}