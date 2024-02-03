package com.flamyoad.listenmoe.com.flamyoad.listenmoe.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.websocket.WebSockets

private const val BASE_URL = "listen.moe"

object KtorWebSocketProvider {

    fun build(): HttpClient {
        return HttpClient(CIO) {
            defaultRequest {
                url(BASE_URL)
            }

            install(WebSockets) {
                pingInterval = 45_000
            }
        }
    }
}