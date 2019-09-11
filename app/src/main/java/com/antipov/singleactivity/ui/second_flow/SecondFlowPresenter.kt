package com.antipov.singleactivity.ui.second_flow

import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class SecondFlowPresenter(private val router: Router) : BasePresenter<SecondFlowView>() {
    fun goBack() {
        router.exit()
    }
}