package com.antipov.singleactivity.ui.third_nested

import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import moxy.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class ThirdNestedPresenter(private val router: Router) : BasePresenter<ThirdNestedView>() {

    fun goNextFlow() = router.navigateTo(Screens.SecondFlow)

    fun onBackPressed() = router.exit()
}