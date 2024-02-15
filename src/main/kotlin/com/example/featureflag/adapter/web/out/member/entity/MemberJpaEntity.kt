package com.example.featureflag.adapter.web.out.member.entity

import com.example.featureflag.adapter.web.out.base.BaseJpaEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class MemberJpaEntity(
    name: String,
    email: String
): BaseJpaEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    var name: String = name
        protected set

}
