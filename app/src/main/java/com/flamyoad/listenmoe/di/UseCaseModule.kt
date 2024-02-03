package com.flamyoad.listenmoe.com.flamyoad.listenmoe.di

import com.flamyoad.listenmoe.com.flamyoad.listenmoe.api.SongsApi
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.usecase.SongsUseCase
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.usecase.SongsUseCaseImpl
import com.flamyoad.listenmoe.core.CustomDispatcher
import com.flamyoad.listenmoe.di.CustomDispatcherModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module(
    includes = [
        ApiModule::class,
        CustomDispatcherModule::class
    ]
)
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideSongUseCase(api: SongsApi, customDispatcher: CustomDispatcher): SongsUseCase {
        return SongsUseCaseImpl(
            api,
            customDispatcher
        )
    }
}