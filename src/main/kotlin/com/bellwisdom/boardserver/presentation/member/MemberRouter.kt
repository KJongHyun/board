package com.bellwisdom.boardserver.presentation.member

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class MemberRouter(
    private val memberHandler: MemberHandler
) {

    companion object {
        const val API_PATH = "/v1/member"
    }

    @Bean
    fun memberRoute(): RouterFunction<ServerResponse> = router {
        (API_PATH).nest {
            POST("/login", memberHandler::login)
            POST("/logout", memberHandler::logout)
        }
    }

}