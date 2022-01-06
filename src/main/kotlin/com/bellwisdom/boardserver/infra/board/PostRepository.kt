package com.bellwisdom.boardserver.infra.board

import com.bellwisdom.boardserver.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}