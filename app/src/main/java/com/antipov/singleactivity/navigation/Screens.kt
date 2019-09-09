package com.antipov.singleactivity.navigation

import android.support.v4.app.Fragment
import com.antipov.singleactivity.ui.first_flow.FirstFlowFragment
import com.antipov.singleactivity.ui.nested.NestedFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Put there your screens.
 */

class Screens {

    object FirstFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = FirstFlowFragment()
    }

    object Nested : SupportAppScreen() {
        override fun getFragment(): NestedFragment = NestedFragment()
    }

}