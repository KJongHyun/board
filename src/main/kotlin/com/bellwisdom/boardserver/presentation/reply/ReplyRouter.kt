package com.bellwisdom.boardserver.presentation.reply

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class ReplyRouter(
    private val replyHandler: ReplyHandler
) {

    companion object {
        private const val API_PATH = "/v1/reply"
    }

    @Bean
    fun replyRoute(): RouterFunction<ServerResponse> = router {
        (API_PATH).nest {
            POST("", replyHandler::write)
            DELETE("/{replyId}", replyHandler::delete)
        }
    }
}