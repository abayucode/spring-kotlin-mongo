package com.abayu.yuhu.springkotlinmongo.services

import com.abayu.yuhu.springkotlinmongo.documents.User
import com.abayu.yuhu.springkotlinmongo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun saveNewUser(user: User): User {
        return userRepository.insert(user)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun getUserDetail(id: String): ResponseEntity<User> {
        val user = userRepository.findById(id)

        return if (user.isEmpty) ResponseEntity.notFound().build() else return ResponseEntity.ok(user.get())
    }

    override fun deleteUser(id: String) {
        return userRepository.deleteById(id)
    }

    override fun updateUser(user: User): ResponseEntity<User> {
        val oldUser = userRepository.findById(user.id).get()
        oldUser.fullName = user.fullName
        oldUser.address = user.address
        oldUser.password = user.password
        oldUser.profession = user.profession

        return ResponseEntity.ok(userRepository.save(oldUser))
    }
}