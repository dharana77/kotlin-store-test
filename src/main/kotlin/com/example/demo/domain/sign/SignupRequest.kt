package com.example.demo.domain.sign

import com.example.demo.enums.SignSnsType

data class SignupRequest(
    val username: String,
    val password: String,
    val email: String,
    val snsType: SignSnsType
)
