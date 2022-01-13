package com.bellwisdom.boardserver.application.reply

import com.bellwisdom.boardserver.presentation.reply.ReplyDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ReplyService {

    fun write(replyDto: ReplyDto): Mono<Unit> {
        return Mono.empty()
    }

    fun delete(replyId: Long): Mono<Unit> {
        return Mono.empty()
    }
}