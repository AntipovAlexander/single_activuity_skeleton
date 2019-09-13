package com.antipov.singleactivity.navigation

import androidx.fragment.app.Fragment
import com.antipov.singleactivity.ui.first_flow.FirstFlowFragment
import com.antipov.singleactivity.ui.first_nested.FirstNestedFragment
import com.antipov.singleactivity.ui.second_flow.SecondFlowFragment
import com.antipov.singleactivity.ui.second_nested.SecondNestedFragment
import com.antipov.singleactivity.ui.third_nested.ThirdNestedFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Put there your screens.
 */

class Screens {

    object FirstFlow : SupportAppScreen() {
        override fun getFragment(): androidx.fragment.app.Fragment = FirstFlowFragment()
    }

    object SecondFlow : SupportAppScreen() {
        override fun getFragment(): androidx.fragment.app.Fragment = SecondFlowFragment()
    }

    object FirstNested : SupportAppScreen() {
        override fun getFragment(): FirstNestedFragment = FirstNestedFragment()
    }

    object SecondNested : SupportAppScreen() {
        override fun getFragment(): SecondNestedFragment = SecondNestedFragment()
    }

    object ThirdNested : SupportAppScreen() {
        override fun getFragment(): ThirdNestedFragment = ThirdNestedFragment()
    }

}