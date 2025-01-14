package com.abayu.yuhu.springkotlinmongo.repositories

import com.abayu.yuhu.springkotlinmongo.documents.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.web.bind.annotation.RestController

@RestController
interface UserRepository : MongoRepository<User, String> {
    fun findUserByUsername(username: String): User
}