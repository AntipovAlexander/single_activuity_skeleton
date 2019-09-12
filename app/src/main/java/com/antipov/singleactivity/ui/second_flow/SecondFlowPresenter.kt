package com.antipov.singleactivity.ui.second_flow

import com.antipov.singleactivity.data.repository.ReactiveRepository
import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

@InjectViewState
class SecondFlowPresenter(
    private val reactiveRepository: ReactiveRepository,
    private val router: Router
) : BasePresenter<SecondFlowView>() {

    fun onViewCreated() {
        launch { reactiveRepository.getChannel().send("SECOND FLOW RUNNING") }
    }

    fun goBack() {
        router.exit()
    }
}