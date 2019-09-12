package com.antipov.singleactivity.ui.second_nested.di

import android.support.v7.app.AppCompatActivity
import com.antipov.singleactivity.di.NestedNavigator
import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.second_nested.SecondNestedFragment
import com.antipov.singleactivity.ui.second_nested.SecondNestedPresenter
import com.antipov.singleactivity.ui.third_nested.ThirdNestedFragment
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
        @NestedNavigator
        fun provideNestedNavigation(fragment: SecondNestedFragment) =
            AppNavigator(
                fragment.activity as AppCompatActivity,
                fragment.parentFragment?.childFragmentManager ?: fragment.childFragmentManager,
                0
            )

        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter(router: Router) = SecondNestedPresenter(router)
    }
}