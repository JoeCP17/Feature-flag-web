package com.example.featureflag.domain.flag

import java.time.LocalDateTime

class FeatureFlag(
    val id: Long? = null,
    val name: String,
    val active: Boolean = true,
    val createdAt: LocalDateTime? = null
) {
    private var activeFlag: Boolean = active

    init {
        require(name.isNotBlank()) { "이름에 현재 빈값이 들어있습니다." }
    }

    fun statusUpdate(): FeatureFlag  = FeatureFlag(
        id = this.id,
        name = this.name,
        active = !this.activeFlag,
        createdAt = this.createdAt
    )


}
