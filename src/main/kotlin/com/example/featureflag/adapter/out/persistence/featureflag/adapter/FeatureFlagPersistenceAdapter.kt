package com.example.featureflag.adapter.out.persistence.featureflag.adapter

import com.example.featureflag.adapter.out.persistence.featureflag.repository.FeatureFlagJpaRepository
import com.example.featureflag.adapter.out.persistence.mapper.FeatureFlagMapper
import com.example.featureflag.application.port.out.FeatureFlagPersistencePort
import com.example.featureflag.domain.flag.FeatureFlag
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Component
class FeatureFlagPersistenceAdapter(
    private val featureFlagJpaRepository: FeatureFlagJpaRepository
): FeatureFlagPersistencePort {
    override fun isActiveByName(featureFlagName: String): Boolean {
        val featureFlagJpaEntity = featureFlagJpaRepository.findByName(featureFlagName)
            .orElseThrow { throw IllegalArgumentException(NOT_FOUNR_MESSAGE) }

        return featureFlagJpaEntity.activeFlag
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): FeatureFlag {
        val featureFlagJpaEntity = featureFlagJpaRepository.findById(id)
            .orElseThrow { throw IllegalArgumentException(NOT_FOUNR_MESSAGE) }

        return FeatureFlagMapper.toDomain(featureFlagJpaEntity)
    }

    @Transactional
    override fun save(featureFlag: FeatureFlag): FeatureFlag {
        val featureFlagJpaEntity = FeatureFlagMapper.toEntity(featureFlag)
        val savedFeatureFlagJpaEntity = featureFlagJpaRepository.save(featureFlagJpaEntity)

        return FeatureFlagMapper.toDomain(savedFeatureFlagJpaEntity)
    }

    @Transactional
    override fun modify(featureFlag: FeatureFlag): FeatureFlag {
        val featureFlagJpaEntity = featureFlagJpaRepository.findById(featureFlag.id!!)
            .orElseThrow { throw IllegalArgumentException(NOT_FOUNR_MESSAGE)  }

        featureFlagJpaEntity.updateFeatureFlag(
            name = featureFlag.name,
            active = featureFlag.active
        )

        return FeatureFlagMapper.toDomain(featureFlagJpaEntity)
    }

    @Transactional
    override fun delete(id: Long) {
        val featureFlagJpaEntity = featureFlagJpaRepository.findById(id)
            .orElseThrow { throw IllegalArgumentException(NOT_FOUNR_MESSAGE) }

        featureFlagJpaRepository.delete(featureFlagJpaEntity)
    }


    companion object {
        private const val NOT_FOUNR_MESSAGE = "Feature Flag를 찾을 수 없습니다."
    }


}
