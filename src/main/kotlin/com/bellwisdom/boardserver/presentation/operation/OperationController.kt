package com.bellwisdom.boardserver.presentation.operation

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@RestController
class OperationController {

    @GetMapping("/api/ping")
    fun operator(): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("PONG"), String::class.java)
    }
}