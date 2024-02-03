package com.flamyoad.listenmoe.com.flamyoad.listenmoe.di

import com.apollographql.apollo3.ApolloClient
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.network.ApolloProvider
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.network.KtorHttpProvider
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.network.KtorWebSocketProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Named

internal const val KTOR_API_CLIENT = "KTOR_API"
internal const val KTOR_WEBSOCKET_CLIENT = "KTOR_WEBSOCKET"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named(KTOR_API_CLIENT)
    fun provideKtorApiClient(): HttpClient {
        return KtorHttpProvider.build()
    }

    @Provides
    @Named(KTOR_WEBSOCKET_CLIENT)
    fun provideKtorWebSocketClient(): HttpClient {
        return KtorWebSocketProvider.build()
    }

    @Provides
    fun provideApolloClient(): ApolloClient {
        return ApolloProvider.build()
    }
}