package com.dk.plugins

import com.dk.models.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, _ ->
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Page not found"
                ),
                status = HttpStatusCode.NotFound
            )
        }
        exception<Exception>{ call, _ ->
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Internal Server Error"
                ),
                status = HttpStatusCode.InternalServerError
            )
        }
    }
}