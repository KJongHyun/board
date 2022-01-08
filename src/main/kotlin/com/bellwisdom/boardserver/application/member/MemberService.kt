package com.bellwisdom.boardserver.application.member

import com.bellwisdom.boardserver.infra.member.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun login() {

    }

    fun logout() {

    }

}