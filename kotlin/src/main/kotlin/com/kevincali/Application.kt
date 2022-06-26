package com.kevincali

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8888) {
        configureRouting()
    }.start(wait = true)
}

fun Application.configureRouting() {
    routing {
        get("/ping") { pong(call) }
    }
}

var counter = 0

suspend fun pong(call: ApplicationCall) {
    val log = call.application.environment.log
    log.info("Kotlin got called ${++counter} times!")

    call.respondText("Hey there, Go!")

    runCatching {
        HttpClient().get("http://localhost:9999/ping")
    }.onFailure {
        log.error("Error: ${it.message}")
    }
}
