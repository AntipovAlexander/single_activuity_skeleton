package com.antipov.singleactivity.ui.second_flow.di

import androidx.appcompat.app.AppCompatActivity
import com.antipov.singleactivity.R
import com.antipov.singleactivity.data.repository.ReactiveRepository
import com.antipov.singleactivity.di.scopes.PerFragment
import com.antipov.singleactivity.domain.GetData
import com.antipov.singleactivity.navigation.AppNavigator
import com.antipov.singleactivity.ui.second_flow.SecondFlowFragment
import com.antipov.singleactivity.ui.second_flow.SecondFlowPresenter
import com.antipov.singleactivity.utils.util.FirstFlowDependency
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
abstract class SecondFlowModule {

    @Module
    companion object {

        @Provides
        @PerFragment
        @JvmStatic
        @SecondFlowNavigator
        fun provideSecondFlowNav(flowFragment: SecondFlowFragment) =
            AppNavigator(
                flowFragment.activity as AppCompatActivity,
                flowFragment.childFragmentManager,
                R.id.secondFlowContainer
            )

        @Provides
        @PerFragment
        @JvmStatic
        fun providePresenter(getDataUseCase: GetData, reactiveRepository: ReactiveRepository, router: Router) =
            SecondFlowPresenter(getDataUseCase, reactiveRepository, router)


        @Provides
        @PerFragment
        @JvmStatic
        fun getDataUseCase() = GetData()

        @Provides
        @PerFragment
        @JvmStatic
        fun provideHostDependency() = FirstFlowDependency()
    }
}