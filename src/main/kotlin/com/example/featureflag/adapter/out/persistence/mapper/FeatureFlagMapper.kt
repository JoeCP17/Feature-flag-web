package com.example.featureflag.adapter.out.persistence.mapper

import com.example.featureflag.adapter.out.persistence.featureflag.entity.FeatureFlagJpaEntity
import com.example.featureflag.domain.flag.FeatureFlag

object FeatureFlagMapper {

    fun toEntity(featureFlag: FeatureFlag): FeatureFlagJpaEntity {
        return FeatureFlagJpaEntity(
            name = featureFlag.name,
            active = featureFlag.active
        )
    }

    fun toDomain(featureFlagJpaEntity: FeatureFlagJpaEntity): FeatureFlag {
        return FeatureFlag(
            id = featureFlagJpaEntity.id,
            name = featureFlagJpaEntity.name,
            active = featureFlagJpaEntity.activeFlag,
            createdAt = featureFlagJpaEntity.createdAt!!
        )
    }

}