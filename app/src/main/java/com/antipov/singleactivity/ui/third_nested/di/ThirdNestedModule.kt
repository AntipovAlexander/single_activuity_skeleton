package com.antipov.singleactivity.ui.third_nested.di

import androidx.appcompat.app.AppCompatActivity
import com.antipov.singleactivity.di.NestedNavigator
import com.antipov.singleactivity.di.scopes.PerChildFragment
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.third_nested.ThirdNestedFragment
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
        @NestedNavigator
        fun provideFirstFlowNav(fragment: ThirdNestedFragment) =
            AppNavigator(
                fragment.activity as AppCompatActivity,
                fragment.parentFragment?.childFragmentManager ?: fragment.childFragmentManager,
                0
            )

        @Provides
        @PerChildFragment
        @JvmStatic
        fun providePresenter(router: Router) = ThirdNestedPresenter(router)
    }
}