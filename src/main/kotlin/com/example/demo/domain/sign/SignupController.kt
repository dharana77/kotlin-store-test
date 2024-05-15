package com.example.demo.domain.sign

import com.example.demo.common.response.ModuResponse
import com.example.demo.domain.sign.data.SignupResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/signup")
class SignupController {

    @RequestMapping("/user")
    fun signupUser(signupRequest: SignupRequest): String{

        return "User signed up"
    }

    @RequestMapping("/admin")
    fun signupAdmin(): String {
        return "Admin signed up"
    }
}