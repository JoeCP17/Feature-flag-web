package com.example.featureflag.adapter.`in`.web.annotation

@Target(AnnotationTarget.FUNCTION)
annotation class FeatureFlag(
    val name: String
)
