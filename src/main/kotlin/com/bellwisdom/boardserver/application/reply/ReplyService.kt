package com.bellwisdom.boardserver.application.reply

import com.bellwisdom.boardserver.domain.member.Member
import com.bellwisdom.boardserver.domain.reply.Reply
import com.bellwisdom.boardserver.infra.post.PostRepository
import com.bellwisdom.boardserver.infra.reply.ReplyRepository
import com.bellwisdom.boardserver.presentation.reply.ReplyDto
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ReplyService(
    private val postRepository: PostRepository,
    private val replyRepository: ReplyRepository
) {

    fun write(replyDto: ReplyDto): Mono<Unit> {
        return Mono.fromCallable {
            postRepository.findByIdOrNull(replyDto.postId)
        }.switchIfEmpty(Mono.error(RuntimeException("[reply 쓰기 실패] post is null -> postId:${replyDto.postId}")))
            .flatMap { post ->
                replyRepository.save(
                    Reply(
                        member = Member(email = "email", password = "password"),
                        post = post!!,
                        contents = replyDto.contents
                    )
                )
                Mono.empty()
            }
    }

    fun delete(replyId: Long): Mono<Unit> {
        return Mono.empty()
    }
}