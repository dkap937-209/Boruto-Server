package com.dk.routes

import com.dk.models.ApiResponse
import com.dk.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes(){

    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes"){
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiResponse = heroRepository.getAllHero(page = page)
            val applicationId = call.request.headers["X-Application-ID"]
            println("endpoint = ${call.request.path()} || applicationId = $applicationId || responsePayload = $apiResponse")
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )

        } catch(e: NumberFormatException){
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Allowed"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not Found"),
                status = HttpStatusCode.NotFound
            )
        }

    }
}