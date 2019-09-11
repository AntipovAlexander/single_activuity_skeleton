package com.antipov.singleactivity.ui.first_nested

import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class FirstNestedPresenter(private val router: Router) : BasePresenter<FirstNestedView>() {

    fun goNext() {
        router.navigateTo(Screens.SecondNested)
    }
}