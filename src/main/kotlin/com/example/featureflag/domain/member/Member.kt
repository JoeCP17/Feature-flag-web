package com.example.featureflag.domain.member

import java.time.LocalDateTime

class Member(
    val id: Long? = null,
    val name: String,
    val createdAt: LocalDateTime? = null
)
