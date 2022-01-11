package com.bellwisdom.boardserver.domain.post

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Reply(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val replyId: Long = 0,
    val contents: String
)