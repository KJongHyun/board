package com.bellwisdom.boardserver.infra.member

import com.bellwisdom.boardserver.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}