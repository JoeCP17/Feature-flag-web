package com.example.featureflag.application.port.`in`

import com.example.featureflag.application.dto.request.RequestFeatureFlagCommand
import com.example.featureflag.application.dto.response.FeatureFlagResponse

interface RequestFeatureFlagUsecase {

    fun create(requestFeatureFlagCommand: RequestFeatureFlagCommand): FeatureFlagResponse

    fun modifyActive(id: Long): FeatureFlagResponse

    fun delete(id: Long)

}