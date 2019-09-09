package com.antipov.singleactivity.navigation

import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Put here your new implementation of AppNavigator, if it needed
 */
class AppNavigator : BaseNavigator {

    constructor(activity: AppCompatActivity, @IdRes layout: Int) : super(
        activity,
        layout
    )

    constructor(activity: AppCompatActivity, childFragmentManager: FragmentManager, @IdRes layout: Int) : super(
        activity,
        childFragmentManager,
        layout
    )
}