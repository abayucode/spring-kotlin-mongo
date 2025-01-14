package com.abayu.yuhu.springkotlinmongo.services

import com.abayu.yuhu.springkotlinmongo.dto.AuthenticationRequestDTO
import org.springframework.stereotype.Service

@Service
interface SecurityService {
    fun login(param: AuthenticationRequestDTO)
    fun logout()
    fun forgetPassword()
}