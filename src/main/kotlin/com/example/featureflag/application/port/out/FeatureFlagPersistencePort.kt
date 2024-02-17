package com.example.featureflag.application.port.out

import com.example.featureflag.domain.flag.FeatureFlag

interface FeatureFlagPersistencePort {
    fun isActiveByName(featureFlagName: String): Boolean
    fun getAll(): List<FeatureFlag>
    fun findById(id: Long): FeatureFlag
    fun save(featureFlag: FeatureFlag): FeatureFlag
    fun modify(featureFlag: FeatureFlag): FeatureFlag
    fun delete(id: Long)

}
