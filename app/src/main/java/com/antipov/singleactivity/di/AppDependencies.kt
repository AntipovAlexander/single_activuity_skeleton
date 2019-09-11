package com.antipov.singleactivity.di

import com.antipov.singleactivity.utils.util.SingletonDependency
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDependencies {

    @Provides
    @Singleton
    fun provideSingleton() = SingletonDependency().apply {
        value = "this is singleton dependency"
    }

}