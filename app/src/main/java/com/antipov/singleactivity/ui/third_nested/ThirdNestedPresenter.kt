package com.antipov.singleactivity.ui.third_nested

import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class ThirdNestedPresenter(private val router: Router) : BasePresenter<ThirdNestedView>() {
    fun goNextFlow() {
        router.exit()
    }
}