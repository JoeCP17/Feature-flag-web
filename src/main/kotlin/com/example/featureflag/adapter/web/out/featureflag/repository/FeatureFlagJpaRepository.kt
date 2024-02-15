package com.example.featureflag.adapter.web.out.featureflag.repository

import com.example.featureflag.adapter.web.out.featureflag.entity.FeatureFlagJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FeatureFlagJpaRepository: JpaRepository<FeatureFlagJpaEntity, Long> {
}
