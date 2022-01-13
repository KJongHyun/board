package com.bellwisdom.boardserver.presentation.post

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class PostRouter(
    private val postHandler: PostHandler
) {

    companion object {
        private const val API_PATH = "/v1/post"
    }

    @Bean
    fun postRoute(): RouterFunction<ServerResponse> = router {
        (API_PATH).nest {
            POST("", postHandler::write)
            GET("/{postId}", postHandler::read)
            DELETE("/{postId}", postHandler::delete)
        }
    }
}