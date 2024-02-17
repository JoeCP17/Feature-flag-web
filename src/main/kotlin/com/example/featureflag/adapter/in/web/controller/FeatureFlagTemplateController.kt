package com.example.featureflag.adapter.`in`.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FeatureFlagTemplateController {

    @GetMapping
    fun featureFlagTemplate(): String {
        return "feature-flags"
    }
}
