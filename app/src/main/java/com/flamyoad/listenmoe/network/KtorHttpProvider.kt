package com.flamyoad.listenmoe.com.flamyoad.listenmoe.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://listen.moe/api/"
private const val TIME_OUT = 60_000

object KtorHttpProvider {

    fun build(): HttpClient {
        return HttpClient(Android) {
            defaultRequest {
                url(BASE_URL)
            }

            install(ContentNegotiation) {
                // Because api wrongly returns ContentType: text/html, so we have to compromise
                register(ContentType.Text.Html, KotlinxSerializationConverter(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                ))
            }

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }

            install(Logging) {
                level = LogLevel.ALL
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header(HttpHeaders.Accept, "application/vnd.listen.v4+json")
            }
        }
    }
}