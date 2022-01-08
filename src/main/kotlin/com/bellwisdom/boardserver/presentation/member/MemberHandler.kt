package com.bellwisdom.boardserver.presentation.member

import com.bellwisdom.boardserver.application.member.MemberService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class MemberHandler(
    private val memberService: MemberService
) {

    fun login(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().build()
    }

    fun logout(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().build()
    }

}