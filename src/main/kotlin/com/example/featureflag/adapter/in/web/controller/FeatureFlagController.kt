package com.example.featureflag.adapter.`in`.web.controller

import com.example.featureflag.adapter.`in`.web.dto.BaseResponseDto
import com.example.featureflag.application.dto.request.RequestFeatureFlagCommand
import com.example.featureflag.application.dto.response.FeatureFlagResponse
import com.example.featureflag.application.port.`in`.RequestFeatureFlagUsecase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/feature-flag")
class FeatureFlagController(
    private val requestFeatureFlagUsecase: RequestFeatureFlagUsecase
) {

    @PostMapping("/create")
    fun createFeatureFlag(@RequestBody requestFeatureFlagCommand: RequestFeatureFlagCommand): BaseResponseDto<FeatureFlagResponse> {
        val response = requestFeatureFlagUsecase.create(requestFeatureFlagCommand)

        return BaseResponseDto.success(
            data = response
        )
    }

    @PatchMapping("/modify/{id}")
    fun modifyFeatureFlag(@PathVariable id: Long): BaseResponseDto<FeatureFlagResponse> {
        val response = requestFeatureFlagUsecase.modifyActive(id)

        return BaseResponseDto.success(
            data = response
        )
    }

    @DeleteMapping("/delete/{id}")
    fun deleteFeatureFlag(@PathVariable id: Long): BaseResponseDto<Any> {
        requestFeatureFlagUsecase.delete(id)
        return BaseResponseDto.success()
    }

}