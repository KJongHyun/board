package com.bellwisdom.boardserver.application.board

import com.bellwisdom.boardserver.domain.post.Post
import com.bellwisdom.boardserver.infra.board.PostRepository
import com.bellwisdom.boardserver.infra.logger.BoardLogger
import com.bellwisdom.boardserver.presentation.board.PostDto
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import javax.transaction.Transactional

@Service
class BoardService(
    private val postRepository: PostRepository
) {

    companion object : BoardLogger

    fun write(postDto: PostDto): Mono<Unit> {
        return Mono.fromCallable { postRepository.save(Post.of(postDto)) }.flatMap {
            Mono.empty()
        }
    }

    fun read(postId: Long): Mono<PostDto> {
        return Mono.fromCallable {
            postRepository.findByIdOrNull(postId)
        }.switchIfEmpty(Mono.error(RuntimeException("[post 리드 실패] post is null -> postId:$postId"))).flatMap {
            with(it!!) {
                Mono.just(
                    PostDto(
                        category = category,
                        title = title,
                        contents = contents
                    )
                )
            }
        }
    }

    @Transactional
    fun delete(postId: Long): Mono<Unit> {
        return Mono.fromCallable {
            postRepository.findByIdOrNull(postId)
        }.switchIfEmpty(Mono.error(RuntimeException("[post 삭제 실패] post is null -> postId:$postId"))).flatMap {
            it!!.delete()
            Mono.empty()
        }
    }
}