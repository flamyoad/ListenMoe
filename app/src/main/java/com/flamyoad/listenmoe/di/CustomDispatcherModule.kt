package com.flamyoad.listenmoe.di

import com.flamyoad.listenmoe.core.CustomDispatcher
import com.flamyoad.listenmoe.core.CustomDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CustomDispatcherModule {

    @Binds
    abstract fun bindCustomDispatcher(customDispatcher: CustomDispatcherImpl): CustomDispatcher
}