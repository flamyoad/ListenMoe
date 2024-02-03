package com.flamyoad.listenmoe.com.flamyoad.listenmoe.api

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.http.HttpFetchPolicy
import com.flamyoad.listenmoe.SongQuery
import com.apollographql.apollo3.cache.http.httpExpireTimeout
import com.apollographql.apollo3.cache.http.httpFetchPolicy
import java.util.concurrent.TimeUnit

interface SongsApi {
    suspend fun getSongDetails(songId: Int): SongQuery.Data?
}

class SongsApiImpl(private val client: ApolloClient): SongsApi {

    override suspend fun getSongDetails(songId: Int): SongQuery.Data? {
        val response = client.query(SongQuery(songId))
            .httpFetchPolicy(HttpFetchPolicy.CacheFirst)
            .httpExpireTimeout(TimeUnit.DAYS.toMillis(1))
            .execute()
        return response.data
    }

}