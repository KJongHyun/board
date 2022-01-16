package com.bellwisdom.boardserver.presentation.post

import com.bellwisdom.boardserver.application.post.PostService
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/post")
class PostController(private val postService: PostService) {

    @PostMapping
    fun write(@RequestBody postDto: PostDto): Mono<ServerResponse> {
        return postService.write(postDto)
    }

    @GetMapping("/{postId}")
    fun read(@PathVariable postId: Long): Mono<ServerResponse> {
        return postService.read(postId)
    }

    @DeleteMapping("/{postId}")
    fun delete(@PathVariable postId: Long): Mono<ServerResponse> {
        return postService.delete(postId)
    }

}