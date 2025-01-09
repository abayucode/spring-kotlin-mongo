package com.abayu.yuhu.springkotlinmongo.services

import com.abayu.yuhu.springkotlinmongo.documents.User
import org.springframework.http.ResponseEntity


interface UserService {
    fun saveNewUser(user: User): User
    fun findAll(): List<User>
    fun getUserDetail(id: String): ResponseEntity<User>
    fun deleteUser(id: String)
    fun updateUser(user: User): ResponseEntity<User>
}