package com.example.featureflag.adapter.out.persistence.member.repository

import com.example.featureflag.adapter.out.persistence.member.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository: JpaRepository<MemberJpaEntity, Long> {
}
