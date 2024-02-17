package com.example.featureflag.adapter.out.persistence.featureflag.entity

import com.example.featureflag.adapter.out.persistence.base.BaseJpaEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class FeatureFlagJpaEntity(
    name: String,
    active: Boolean
) : BaseJpaEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    var name: String = name
        protected set

    var activeFlag: Boolean = active
        protected set

    fun updateFeatureFlag(name: String, active: Boolean) {
        this.name = name
        this.activeFlag = active
    }

}
