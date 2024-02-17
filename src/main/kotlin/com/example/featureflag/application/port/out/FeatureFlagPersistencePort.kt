package com.example.featureflag.application.port.out

import com.example.featureflag.domain.flag.FeatureFlag

interface FeatureFlagPersistencePort {
    fun findById(id: Long): FeatureFlag
    fun save(featureFlag: FeatureFlag): FeatureFlag
    fun modify(featureFlag: FeatureFlag): FeatureFlag
    fun delete(id: Long)

}