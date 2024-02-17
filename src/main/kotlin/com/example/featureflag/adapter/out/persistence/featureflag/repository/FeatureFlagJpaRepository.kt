package com.example.featureflag.adapter.out.persistence.featureflag.repository

import com.example.featureflag.adapter.out.persistence.featureflag.entity.FeatureFlagJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FeatureFlagJpaRepository: JpaRepository<FeatureFlagJpaEntity, Long> {

    fun findByName(name: String): Optional<FeatureFlagJpaEntity>
}
