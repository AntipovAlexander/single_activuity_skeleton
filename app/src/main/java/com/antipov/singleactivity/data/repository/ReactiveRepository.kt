package com.antipov.singleactivity.data.repository

import kotlinx.coroutines.channels.Channel

interface ReactiveRepository {
    fun getChannel(): Channel<String>
}