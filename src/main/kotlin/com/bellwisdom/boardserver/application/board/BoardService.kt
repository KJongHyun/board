package com.bellwisdom.boardserver.application.board

import com.bellwisdom.boardserver.domain.Post
import com.bellwisdom.boardserver.infra.board.PostRepository
import com.bellwisdom.boardserver.presentation.board.PostDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BoardService(
    private val postRepository: PostRepository
) {
    fun write(postDto: PostDto): Mono<Unit> {
        return Mono.fromCallable { postRepository.save(Post.of(postDto)) }.flatMap {
            Mono.empty()
        }
    }
}