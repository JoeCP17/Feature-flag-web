package com.example.featureflag.adapter.`in`.web.aspect

import com.example.featureflag.adapter.`in`.web.annotation.FeatureFlag
import com.example.featureflag.application.port.`in`.RequestFeatureFlagUsecase
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class FeatureFlagAspect(
    private val featureFlagUsecase: RequestFeatureFlagUsecase
) {
    @Around("@annotation(featureFlag)")
    fun featureFlagAspect(joinPoint: ProceedingJoinPoint, featureFlag: FeatureFlag): Any {
        val featureFlagName = featureFlag.name

        if (!featureFlagUsecase.isFeatureFlagActiveByName(featureFlagName)) {
            throw RuntimeException()
        }

        return joinPoint.proceed()
    }

}
