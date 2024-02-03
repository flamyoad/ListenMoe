package com.flamyoad.listenmoe.com.flamyoad.listenmoe.api.socket

import com.flamyoad.listenmoe.com.flamyoad.listenmoe.di.KTOR_WEBSOCKET_CLIENT
import io.ktor.client.HttpClient
import javax.inject.Named

interface ListenMoeSocket {

}

class ListenMoeSocketImpl(
    @Named(KTOR_WEBSOCKET_CLIENT) private val client: HttpClient
): ListenMoeSocket {

}