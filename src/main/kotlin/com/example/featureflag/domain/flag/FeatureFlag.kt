package com.example.featureflag.domain.flag

import java.time.LocalDateTime

class FeatureFlag(
    val id: Long? = null,
    val name: String,
    val active: Boolean = true,
    val createdAt: LocalDateTime? = null
) {
    private var activeFlag: Boolean = active

    fun statusUpdate(): FeatureFlag  = FeatureFlag(
        id = this.id,
        name = this.name,
        active = !this.activeFlag,
        createdAt = this.createdAt
    )


}
