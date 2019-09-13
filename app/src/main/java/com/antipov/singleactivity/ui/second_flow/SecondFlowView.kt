package com.antipov.singleactivity.ui.second_flow

import com.antipov.singleactivity.ui.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SecondFlowView : BaseView {
    fun updateTv(message: String)
}