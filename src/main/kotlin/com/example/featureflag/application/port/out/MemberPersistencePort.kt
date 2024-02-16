package com.example.featureflag.application.port.out

import com.example.featureflag.domain.member.Member

interface MemberPersistencePort {

    fun saveMember(member:Member): Member

    fun getMemberById(id: Long): Member
}
