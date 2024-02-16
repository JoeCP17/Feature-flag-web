package com.example.featureflag.application.port.`in`

import com.example.featureflag.application.dto.CreateMemberCommand
import com.example.featureflag.application.dto.MemberResponse

interface RequestMemberUsecase {

    fun registerMember(createMemberCommand: CreateMemberCommand): MemberResponse

    fun getMemberById(id: Long): MemberResponse

}
