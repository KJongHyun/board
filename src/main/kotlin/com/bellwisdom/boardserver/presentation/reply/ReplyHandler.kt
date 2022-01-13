package com.bellwisdom.boardserver.presentation.reply

import com.bellwisdom.boardserver.application.reply.ReplyService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ReplyHandler(
    private val replyService: ReplyService
) {

    fun write(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(ReplyDto::class.java).flatMap { replyDto ->
            replyService.write(replyDto)
        }.flatMap {
            ServerResponse.ok().build()
        }
    }

    fun delete(serverRequest: ServerRequest): Mono<ServerResponse> {
        return replyService.delete(serverRequest.pathVariable("replyId").toLong()).flatMap {
            ServerResponse.ok().build()
        }
    }
}