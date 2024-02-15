package com.example.featureflag.adapter.web.out.featureflag.entity

import com.example.featureflag.adapter.web.out.base.BaseJpaEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class FeatureFlagJpaEntity(
    name: String,
    active: Boolean
) : BaseJpaEntity() {
    @Id
    var id: Long? = null
        protected set

    var activeFlag: Boolean = active
        protected set
}
