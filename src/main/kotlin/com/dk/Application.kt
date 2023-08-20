package com.dk

import com.dk.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {

    System.setProperty("io.ktor.development", "true")
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module,
        watchPaths = listOf("classes", "resources"),
    )
    .start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureRouting()
    configureMonitoring()
    configureSerialization()
    configureDefaultHeaders()
    configureStatusPages()
}