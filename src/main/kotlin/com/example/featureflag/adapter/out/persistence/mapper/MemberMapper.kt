package com.example.featureflag.adapter.out.persistence.mapper

import com.example.featureflag.adapter.out.persistence.member.entity.MemberJpaEntity
import com.example.featureflag.domain.member.Member

object MemberMapper {
    fun toEntity(member: Member) = MemberJpaEntity(
        name = member.name
    )

    fun toDomain(entity: MemberJpaEntity) = Member(
        id = entity.id!!,
        name = entity.name,
        createdAt = entity.createdAt
    )
}
