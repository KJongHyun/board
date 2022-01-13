package com.bellwisdom.boardserver.domain.post

import com.bellwisdom.boardserver.domain.BaseEntity
import com.bellwisdom.boardserver.presentation.post.PostDto
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long = 0,
    @Enumerated(EnumType.STRING)
    val category: Category,
    var title: String,
    var contents: String,
) : BaseEntity() {

    @Enumerated(EnumType.STRING)
    var status: PostStatus = PostStatus.READABLE

    private var deletedAt: LocalDateTime? = null

    companion object {
        fun of(postDto: PostDto): Post {
            return Post(category = postDto.category, title = postDto.title, contents = postDto.contents)
        }
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