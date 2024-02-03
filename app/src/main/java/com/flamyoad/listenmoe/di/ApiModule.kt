package com.flamyoad.listenmoe.com.flamyoad.listenmoe.di

import com.apollographql.apollo3.ApolloClient
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.api.SongsApi
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.api.SongsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        NetworkModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideSongsApi(client: ApolloClient): SongsApi {
        return SongsApiImpl(client)
    }


}