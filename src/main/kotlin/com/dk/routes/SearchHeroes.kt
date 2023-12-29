package com.dk.routes

import com.dk.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes(){

    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes/search"){
        val name = call.request.queryParameters["name"]

        val apiResponse = heroRepository.searchHeroes(name = name)
        val applicationId = call.request.headers["X-Application-ID"]
        val localAddress = call.request.local.localAddress
        val remoteAddress = call.request.local.remoteAddress
        println("endpoint = ${call.request.path()} || applicationId = $applicationId || localAddress = $localAddress || remoteAddress = $remoteAddress|| responsePayload = $apiResponse")
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}