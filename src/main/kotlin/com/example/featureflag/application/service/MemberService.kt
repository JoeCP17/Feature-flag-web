package com.example.featureflag.application.service

import com.example.featureflag.application.dto.request.CreateMemberCommand
import com.example.featureflag.application.dto.response.MemberResponse
import com.example.featureflag.application.port.`in`.RequestMemberUsecase
import com.example.featureflag.application.port.out.MemberPersistencePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberPersistencePort: MemberPersistencePort
): RequestMemberUsecase {

    @Transactional
    override fun registerMember(createMemberCommand: CreateMemberCommand): MemberResponse {
        val saveMember = memberPersistencePort.saveMember(createMemberCommand.toMember())

        return MemberResponse(
            id = saveMember.id!!,
            name = saveMember.name,
            createdAt = saveMember.createdAt!!
        )
    }

    @Transactional
    override fun getMemberById(id: Long): MemberResponse {
        val findMember = memberPersistencePort.getMemberById(id)

        return MemberResponse(
            id = findMember.id!!,
            name = findMember.name,
            createdAt = findMember.createdAt!!
        )
    }

}
