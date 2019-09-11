package com.antipov.singleactivity.ui.first_flow

import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class FirstFlowPresenter(private val router: Router) : BasePresenter<FirstFlowView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun enterNested() {
        router.navigateTo(Screens.FirstNested)
    }
}