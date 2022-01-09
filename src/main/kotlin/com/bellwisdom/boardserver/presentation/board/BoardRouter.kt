package com.bellwisdom.boardserver.presentation.board

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class BoardRouter(
    private val boardHandler: BoardHandler
) {

    companion object {
        private const val API_PATH = "/v1/board"
    }

    @Bean
    fun boardRoute(): RouterFunction<ServerResponse> = router {
        (API_PATH).nest {
            POST("", boardHandler::write)
            GET("/{postId}", boardHandler::read)
            DELETE("/{postId}", boardHandler::delete)
        }
    }
}