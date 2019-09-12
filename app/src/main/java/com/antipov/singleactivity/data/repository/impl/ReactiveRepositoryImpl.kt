package com.antipov.singleactivity.data.repository.impl

import com.antipov.singleactivity.data.repository.ReactiveRepository
import kotlinx.coroutines.channels.Channel

class ReactiveRepositoryImpl : ReactiveRepository {

    private val channel = Channel<String>()

    override fun getChannel(): Channel<String> = channel
}