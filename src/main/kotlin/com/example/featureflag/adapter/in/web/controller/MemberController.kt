package com.example.featureflag.adapter.`in`.web.controller

import com.example.featureflag.adapter.`in`.web.annotation.FeatureFlag
import com.example.featureflag.adapter.`in`.web.dto.BaseResponseDto
import com.example.featureflag.application.dto.request.CreateMemberCommand
import com.example.featureflag.application.dto.response.MemberResponse
import com.example.featureflag.application.port.`in`.RequestMemberUsecase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    private val requestMemberUsecase: RequestMemberUsecase
) {

    @GetMapping("/{id}", params = ["version=1.0"])
    @FeatureFlag(name = "getMember-v1.0")
    fun getMemberById(@PathVariable id: Long): BaseResponseDto<MemberResponse> {
        val memberById = requestMemberUsecase.getMemberById(id)
        return BaseResponseDto.success(memberById)
    }

    @PostMapping("/register", params = ["version=1.0"])
    @FeatureFlag(name = "registerMember-v1.0")
    fun registerMember(@RequestBody command: CreateMemberCommand): BaseResponseDto<MemberResponse> {
        val registerMember = requestMemberUsecase.registerMember(command)
        return BaseResponseDto.success(registerMember)
    }

}
