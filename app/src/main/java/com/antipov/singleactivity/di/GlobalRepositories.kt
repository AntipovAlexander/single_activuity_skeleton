package com.antipov.singleactivity.di

import com.antipov.singleactivity.data.repository.ReactiveRepository
import com.antipov.singleactivity.data.repository.impl.ReactiveRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GlobalRepositories {

    @Provides
    @Singleton
    fun provideRouter(): ReactiveRepository = ReactiveRepositoryImpl()

}