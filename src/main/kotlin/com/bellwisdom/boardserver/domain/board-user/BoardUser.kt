package com.bellwisdom.boardserver.domain.`board-user`

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class BoardUser(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val boardUserId: Long = 0,
    val email: String,
    val password: String
)