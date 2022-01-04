package com.bellwisdom.boardserver.domain

import com.bellwisdom.boardserver.presentation.board.PostDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long = 0,
    var title: String,
    var contents: String
) {
    companion object {
        fun of(postDto: PostDto): Post {
            return Post(title = postDto.title, contents = postDto.contents)
        }
    }
}