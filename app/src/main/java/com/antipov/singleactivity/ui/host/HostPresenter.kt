package com.antipov.singleactivity.ui.host

import com.antipov.singleactivity.data.repository.ReactiveRepository
import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

@InjectViewState
class HostPresenter(
    private var reactiveRepository: ReactiveRepository,
    private val router: Router
) : BasePresenter<HostView>() {

    @ObsoleteCoroutinesApi
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            reactiveRepository.getChannel().consumeEach {
                viewState.updateCaption(it)
            }
        }
        router.newRootScreen(Screens.FirstFlow)
    }
}