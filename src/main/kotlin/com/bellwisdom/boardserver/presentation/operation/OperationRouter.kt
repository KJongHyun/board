package com.bellwisdom.boardserver.presentation.operation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Configuration
class OperationRouter {

    @Bean
    fun operationRoute(): RouterFunction<ServerResponse> = router {
        GET("/api/ping") {
            ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("PONG"), String::class.java)
        }
    }
}