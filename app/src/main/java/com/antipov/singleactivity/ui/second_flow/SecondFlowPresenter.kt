package com.antipov.singleactivity.ui.second_flow

import com.antipov.singleactivity.data.repository.ReactiveRepository
import com.antipov.singleactivity.domain.GetData
import com.antipov.singleactivity.ui.base.BasePresenter
import kotlinx.coroutines.launch
import moxy.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class SecondFlowPresenter(
    private val getDataUseCase: GetData,
    private val reactiveRepository: ReactiveRepository,
    private val router: Router
) : BasePresenter<SecondFlowView>() {

    fun onViewCreated() {
        launch { reactiveRepository.getChannel().send("SECOND FLOW RUNNING") }
        executeUseCase()
    }

    private fun executeUseCase() = launch {
        getDataUseCase(GetData.Params(1)) {
            it.either({ throwable ->
                viewState.updateTv(
                    throwable.localizedMessage ?: "no message, but you are loose"
                )
            }, { result ->
                viewState.updateTv(result)
            })
        }
    }

    fun goBack() = router.exit()

    fun tryAgain() = executeUseCase()
}