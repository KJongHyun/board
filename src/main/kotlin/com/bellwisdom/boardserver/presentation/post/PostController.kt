package com.bellwisdom.boardserver.presentation.post

import com.bellwisdom.boardserver.application.post.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/test")
class PostController(private val postService: PostService) {

    @GetMapping
    fun test(): Mono<String> {
        return Mono.just("OK")
    }
//    @PostMapping
//    fun write(@RequestBody postDto: PostDto): Mono<ServerResponse> {
//        return postService.write(postDto)
//    }
//
//    @GetMapping("/{postId}")
//    fun read(@PathVariable postId: Long): Mono<ServerResponse> {
//        return postService.read(postId)
//    }
//
//    @DeleteMapping("/{postId}")
//    fun delete(@PathVariable postId: Long): Mono<ServerResponse> {
//        return postService.delete(postId)
//    }

}