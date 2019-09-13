package com.antipov.singleactivity.ui.host

import com.antipov.singleactivity.ui.base.BaseView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface HostView : BaseView {
    fun updateCaption(caption: String)
}