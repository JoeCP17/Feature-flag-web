package com.example.featureflag.application.dto

import com.example.featureflag.domain.member.Member

data class CreateMemberCommand(
    val name: String
) {
    fun toMember() = Member(name = name)
}
