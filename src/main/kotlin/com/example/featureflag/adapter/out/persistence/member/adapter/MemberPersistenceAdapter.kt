package com.example.featureflag.adapter.out.persistence.member.adapter

import com.example.featureflag.adapter.out.persistence.mapper.MemberMapper
import com.example.featureflag.adapter.out.persistence.member.repository.MemberJpaRepository
import com.example.featureflag.application.port.out.MemberPersistencePort
import com.example.featureflag.domain.member.Member
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberPersistenceAdapter(
    private val memberJpaRepository: MemberJpaRepository
): MemberPersistencePort {
    @Transactional
    override fun saveMember(member: Member): Member {
        val requestMemberJpaEntity = MemberMapper.toEntity(member)
        val savedJpaEntity = memberJpaRepository.save(requestMemberJpaEntity)

        return MemberMapper.toDomain(savedJpaEntity)
    }

    @Transactional(readOnly = true)
    override fun getMemberById(id: Long): Member {
        val memberJpaEntity = memberJpaRepository.findById(id)
            .orElseThrow { throw RuntimeException("Member not found") }

        return MemberMapper.toDomain(memberJpaEntity)
    }
}
