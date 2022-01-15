package com.bellwisdom.boardserver.domain.post

import com.bellwisdom.boardserver.domain.BaseEntity
import com.bellwisdom.boardserver.domain.member.Member
import com.bellwisdom.boardserver.domain.reply.Reply
import com.bellwisdom.boardserver.presentation.post.PostDto
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long = 0,
    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,
    @Enumerated(EnumType.STRING)
    val category: Category,
    var title: String,
    var contents: String,
    @OneToMany(mappedBy = "post")
    val replies: MutableList<Reply> = mutableListOf()
) : BaseEntity() {

    @Enumerated(EnumType.STRING)
    var status: PostStatus = PostStatus.READABLE

    private var deletedAt: LocalDateTime? = null

    companion object {
        fun of(member: Member, postDto: PostDto): Post {
            return Post(
                member = member,
                category = postDto.category,
                title = postDto.title,
                contents = postDto.contents
            )
        }
    }

    fun addReply(reply: Reply) {
        reply.post = this
        replies.add(reply)
    }

    fun delete() {
        this.status = PostStatus.DELETED
        this.deletedAt = LocalDateTime.now()
    }
}

enum class Category {
    MARKET,
    STOCK
}

enum class PostStatus {
    READABLE,
    DELETED
}
