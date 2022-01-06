package com.bellwisdom.boardserver.presentation.board

import com.bellwisdom.boardserver.domain.post.Category

data class PostDto(
    val category: Category,
    val title: String,
    val contents: String
)
