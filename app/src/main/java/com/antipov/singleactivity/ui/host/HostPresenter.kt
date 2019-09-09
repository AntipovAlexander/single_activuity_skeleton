package com.antipov.singleactivity.ui.host

import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class HostPresenter(private val router: Router) : BasePresenter<HostView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.FirstFlow)
    }
}