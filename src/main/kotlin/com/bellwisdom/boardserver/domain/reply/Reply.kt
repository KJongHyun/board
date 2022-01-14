package com.bellwisdom.boardserver.domain.reply

import com.bellwisdom.boardserver.domain.BaseEntity
import com.bellwisdom.boardserver.domain.member.Member
import com.bellwisdom.boardserver.domain.post.Post
import com.bellwisdom.boardserver.presentation.reply.ReplyDto
import javax.persistence.*

@Entity
class Reply(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val replyId: Long = 0,
    @ManyToOne
    @JoinColumn(name = "member_id", updatable = false)
    val member: Member,
    @ManyToOne
    @JoinColumn(name = "post_id", updatable = false)
    val post: Post,
    val contents: String
) : BaseEntity() {
    companion object {
        fun of(member: Member, post: Post, replyDto: ReplyDto): Reply {
            return Reply(member = member, post = post, contents = replyDto.contents)
        }
    }
}