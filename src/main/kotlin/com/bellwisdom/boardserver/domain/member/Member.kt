package com.bellwisdom.boardserver.domain.member

import com.bellwisdom.boardserver.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long = 0,
    val email: String,
    val password: String
) : BaseEntity()