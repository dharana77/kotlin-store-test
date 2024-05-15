package com.example.demo.common.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.status
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono


data class Exception(
    var code: String,
    override var message: String,
    var httpStatus: HttpStatus = HttpStatus.CONFLICT,
    val throwable: Throwable? = null
) : RuntimeException(message, throwable)


data class Error(val code: Int, val messages: String = "")

fun badRequest(t: Throwable) = error(HttpStatus.BAD_REQUEST, t)
fun notFound(t: Throwable) = error(HttpStatus.NOT_FOUND, t)

fun methodNotAllowed(t: Throwable) = error(HttpStatus.METHOD_NOT_ALLOWED, t)
fun methodNotAllowed(message: String) = error(HttpStatus.METHOD_NOT_ALLOWED, message)

fun internalServerError(message: String) = error(HttpStatus.INTERNAL_SERVER_ERROR, message)
fun internalServerError(t: Throwable) = error(HttpStatus.INTERNAL_SERVER_ERROR, t)


private fun error(status: HttpStatus, message: String): Mono<ServerResponse> {
    val error = Error(status.value(), message)
    return status(status).body(Mono.just(error))
}

private fun error(status: HttpStatus, t: Throwable): Mono<ServerResponse> {
    val error = Error(status.value(), t.message ?: status.name)
    return status(status).body(Mono.just(error))
}