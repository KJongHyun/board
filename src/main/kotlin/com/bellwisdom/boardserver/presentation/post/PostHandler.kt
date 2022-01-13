package com.bellwisdom.boardserver.presentation.post

import com.bellwisdom.boardserver.application.post.PostService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class PostHandler(private val postService: PostService) {

    fun read(serverRequest: ServerRequest): Mono<ServerResponse> {
        return postService.read(serverRequest.pathVariable("postId").toLong()).flatMap {
            ServerResponse.ok().body(BodyInserters.fromValue(it))
        }
    }

    fun write(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(PostDto::class.java).flatMap { postDto ->
            postService.write(postDto)
        }.flatMap {
            ServerResponse.ok().build()
        }
    }

    fun delete(serverRequest: ServerRequest): Mono<ServerResponse> {
        return postService.delete(serverRequest.pathVariable("postId").toLong()).flatMap {
            ServerResponse.ok().build()
        }
    }
}