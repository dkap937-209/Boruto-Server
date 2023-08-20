package com.dk.plugins

import com.dk.routes.getAllHeroes
import com.dk.routes.root
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()

        staticResources(remotePath = "/images", basePackage = "images")
    }
}

