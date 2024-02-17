package com.example.featureflag.application.dto.response

import java.time.LocalDateTime

data class MemberResponse(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime
) {
}
