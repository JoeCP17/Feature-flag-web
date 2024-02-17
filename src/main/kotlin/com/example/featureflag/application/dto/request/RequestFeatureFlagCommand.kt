package com.example.featureflag.application.dto.request

import com.example.featureflag.domain.flag.FeatureFlag

data class RequestFeatureFlagCommand(
    val name: String
) {

    fun toDomainByName() = FeatureFlag(name = name)

    fun toDomainByIdAndName(id: Long) = FeatureFlag(id = id, name = name)
}