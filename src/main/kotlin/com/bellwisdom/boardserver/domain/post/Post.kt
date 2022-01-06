package com.bellwisdom.boardserver.domain.post

import com.bellwisdom.boardserver.domain.BaseEntity
import com.bellwisdom.boardserver.presentation.board.PostDto
import javax.persistence.*

@Entity
class Post private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long = 0,
    @Enumerated(EnumType.STRING)
    val category: Category,
    var title: String,
    var contents: String
) : BaseEntity() {

    companion object {
        fun of(postDto: PostDto): Post {
            return Post(category = postDto.category, title = postDto.title, contents = postDto.contents)
        }
    }

}

enum class Category {
    MARKET,
    STOCK
}