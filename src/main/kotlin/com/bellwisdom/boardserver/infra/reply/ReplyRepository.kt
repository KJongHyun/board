package com.bellwisdom.boardserver.infra.reply

import com.bellwisdom.boardserver.domain.reply.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long> {
}