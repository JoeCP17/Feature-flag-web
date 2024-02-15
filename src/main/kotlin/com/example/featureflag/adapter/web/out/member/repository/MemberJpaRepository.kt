package com.example.featureflag.adapter.web.out.member.repository

import com.example.featureflag.adapter.web.out.member.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository: JpaRepository<MemberJpaEntity, Long> {
}
