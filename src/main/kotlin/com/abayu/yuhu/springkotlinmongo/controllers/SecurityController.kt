package com.abayu.yuhu.springkotlinmongo.controllers

import com.abayu.yuhu.springkotlinmongo.dto.AuthenticationRequestDTO
import com.abayu.yuhu.springkotlinmongo.services.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class SecurityController(
    @Autowired private val securityService: SecurityService
) {

    @PostMapping("/login")
    fun login(@RequestBody body: AuthenticationRequestDTO) {
        return securityService.login(body)
    }

}