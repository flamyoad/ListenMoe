package com.flamyoad.listenmoe.com.flamyoad.listenmoe.network

import com.apollographql.apollo3.ApolloClient

private const val BASE_URL = "https://listen.moe/graphql"

object ApolloProvider {

    fun build(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .build()
    }
}