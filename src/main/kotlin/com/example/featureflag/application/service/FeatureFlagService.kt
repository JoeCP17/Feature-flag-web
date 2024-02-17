package com.example.featureflag.application.service

import com.example.featureflag.application.dto.request.RequestFeatureFlagCommand
import com.example.featureflag.application.dto.response.FeatureFlagResponse
import com.example.featureflag.application.port.`in`.RequestFeatureFlagUsecase
import com.example.featureflag.application.port.out.FeatureFlagPersistencePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class FeatureFlagService(
    private val featureFlagPersistencePort: FeatureFlagPersistencePort
) : RequestFeatureFlagUsecase {

    @Transactional
    override fun isFeatureFlagActiveByName(featureFlagName: String): Boolean {
        return featureFlagPersistencePort.isActiveByName(featureFlagName)
    }

    @Transactional
    override fun getAllList(): List<FeatureFlagResponse> {
        val featureFlagList = featureFlagPersistencePort.getAll()

        return featureFlagList.map {
            FeatureFlagResponse(
                id = it.id!!,
                name = it.name,
                active = it.active,
                createdAt = it.createdAt!!
            )
        }
    }

    @Transactional
    override fun create(requestFeatureFlagCommand: RequestFeatureFlagCommand): FeatureFlagResponse {
        val requestFeatureFlag = requestFeatureFlagCommand.toDomainByName()
        val savedFeatureFlag = featureFlagPersistencePort.save(requestFeatureFlag)

        return FeatureFlagResponse(
            id = savedFeatureFlag.id!!,
            name = savedFeatureFlag.name,
            active = savedFeatureFlag.active,
            createdAt = savedFeatureFlag.createdAt!!
        )
    }

    @Transactional
    override fun modifyActive(id: Long): FeatureFlagResponse {
        val requestFeatureFlag = featureFlagPersistencePort.findById(id)
        val updateFlagDomain = requestFeatureFlag.statusUpdate()

        val savedFeatureFlag = featureFlagPersistencePort.modify(updateFlagDomain)

        return FeatureFlagResponse(
            id = savedFeatureFlag.id!!,
            name = savedFeatureFlag.name,
            active = savedFeatureFlag.active,
            createdAt = savedFeatureFlag.createdAt!!
        )
    }

    @Transactional
    override fun delete(id: Long) = featureFlagPersistencePort.delete(id)

}
