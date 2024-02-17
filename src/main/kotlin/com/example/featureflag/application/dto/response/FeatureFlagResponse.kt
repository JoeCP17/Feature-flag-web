package com.example.featureflag.application.dto.response

import java.time.LocalDateTime

data class FeatureFlagResponse(
    val id: Long,
    val name: String,
    val active: Boolean,
    val createdAt: LocalDateTime
) {
}