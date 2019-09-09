package com.antipov.singleactivity.utils.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun CoroutineScope.runOnUi(function: () -> Unit) =
    launch(Dispatchers.Main) {
        function.invoke()
    }