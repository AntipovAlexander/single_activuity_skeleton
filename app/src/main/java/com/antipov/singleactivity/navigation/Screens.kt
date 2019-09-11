package com.antipov.singleactivity.navigation

import android.support.v4.app.Fragment
import com.antipov.singleactivity.ui.first_flow.FirstFlowFragment
import com.antipov.singleactivity.ui.first_nested.FirstNestedFragment
import com.antipov.singleactivity.ui.second_nested.SecondNestedFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Put there your screens.
 */

class Screens {

    object FirstFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = FirstFlowFragment()
    }

    object FirstNested : SupportAppScreen() {
        override fun getFragment(): FirstNestedFragment = FirstNestedFragment()
    }

    object SecondNested : SupportAppScreen() {
        override fun getFragment(): SecondNestedFragment = SecondNestedFragment()
    }

}