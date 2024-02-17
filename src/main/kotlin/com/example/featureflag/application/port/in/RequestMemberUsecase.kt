package com.example.featureflag.application.port.`in`

import com.example.featureflag.application.dto.request.CreateMemberCommand
import com.example.featureflag.application.dto.response.MemberResponse

interface RequestMemberUsecase {

    fun registerMember(createMemberCommand: CreateMemberCommand): MemberResponse

    fun getMemberById(id: Long): MemberResponse

}
