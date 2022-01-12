package com.bellwisdom.boardserver.domain.reply

import com.bellwisdom.boardserver.domain.BaseEntity
import com.bellwisdom.boardserver.domain.member.Member
import com.bellwisdom.boardserver.domain.post.Post
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
) : BaseEntity()