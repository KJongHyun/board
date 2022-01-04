package com.bellwisdom.boardserver.presentation.board

import com.bellwisdom.boardserver.application.board.BoardService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class BoardHandler(private val boardService: BoardService) {
    fun write(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(PostDto::class.java).flatMap { postDto ->
            boardService.write(postDto)
        }.flatMap {
            ServerResponse.ok().build()
        }
    }
}