package com.abayu.yuhu.springkotlinmongo.services

import com.abayu.yuhu.springkotlinmongo.dto.AuthenticationRequestDTO
import com.abayu.yuhu.springkotlinmongo.repositories.UserRepository
import com.abayu.yuhu.springkotlinmongo.security.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityServiceImpl (
    @Autowired private val userRepository: UserRepository,
    @Autowired private val authenticationManager: AuthenticationManager,
    @Autowired private val userDetailsService: UserDetailsService,
    @Autowired private val jwtUtils: JwtUtils
) : SecurityService {

    override fun login(param: AuthenticationRequestDTO) {
        val user = userRepository.findUserByUsername(param.username.toString())
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(user, user.password))
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(param.username)
        val jwtToken: String = jwtUtils.generateToken(user)

        println(jwtToken)
    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun forgetPassword() {
        TODO("Not yet implemented")
    }
}