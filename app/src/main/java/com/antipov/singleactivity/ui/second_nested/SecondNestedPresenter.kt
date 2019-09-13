package com.antipov.singleactivity.ui.second_nested

import com.antipov.singleactivity.navigation.Screens
import com.antipov.singleactivity.ui.base.BasePresenter
import moxy.InjectViewState
import ru.terrakok.cicerone.Router

@InjectViewState
class SecondNestedPresenter(private val router: Router) : BasePresenter<SecondNestedView>() {
    fun goNext() = router.navigateTo(Screens.ThirdNested)

    fun onBackPressed() = router.exit()
}