package com.abayu.yuhu.springkotlinmongo.services

import com.abayu.yuhu.springkotlinmongo.documents.User
import com.abayu.yuhu.springkotlinmongo.dto.ApiResult
import org.springframework.http.ResponseEntity


interface UserService {
    fun saveNewUser(user: User): ApiResult<User>
    fun findAll(): ApiResult<List<User>>
    fun getUserDetail(id: String): ApiResult<User>
    fun deleteUser(id: String): ApiResult<String>
    fun updateUser(user: User): ResponseEntity<User>
}