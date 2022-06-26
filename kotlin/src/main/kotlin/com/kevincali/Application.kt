package com.kevincali

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.kevincali.plugins.*

fun main() {
    embeddedServer(Netty, port = 8888, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}
