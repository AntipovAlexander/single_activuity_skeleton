package com.antipov.singleactivity.ui.first_flow

import com.antipov.singleactivity.data.repository.ReactiveRepository
import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

@InjectViewState
class FirstFlowPresenter(
    private val reactiveRepository: ReactiveRepository,
    private val router: Router
) : BasePresenter<FirstFlowView>() {

    fun enterNested() {
        router.navigateTo(Screens.FirstNested)
    }

    fun onViewCreated() {
        launch { reactiveRepository.getChannel().send("FIRST FLOW RUNNING") }
    }
}