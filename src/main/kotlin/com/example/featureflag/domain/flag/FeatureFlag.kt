package com.example.featureflag.domain.flag

import java.time.LocalDateTime

class FeatureFlag(
    val name: String,
    val active: Boolean = false,
    val createdAt: LocalDateTime
) {
    private var activeFlag: Boolean = active

    fun turnActiveTrue() {
        activeFlag = true
    }
}
