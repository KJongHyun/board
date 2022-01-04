package com.bellwisdom.boardserver.presentation.board

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class BoardRouter(
    private val boardHandler: BoardHandler
) {

    companion object {
        private const val API_PATH = "/v1/board"
    }

    @Bean
    fun boardRoute() = router {
        (API_PATH and contentType(MediaType.APPLICATION_JSON)).nest {
            POST("", boardHandler::write)
        }
    }
}