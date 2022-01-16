package com.bellwisdom.boardserver.presentation.reply

import com.bellwisdom.boardserver.application.reply.ReplyService
import org.springframework.web.bind.annotation.RestController

@RestController
class ReplyController(private val replyService: ReplyService) {
}