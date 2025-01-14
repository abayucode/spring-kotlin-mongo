package com.abayu.yuhu.springkotlinmongo.controllers

import com.abayu.yuhu.springkotlinmongo.documents.User
import com.abayu.yuhu.springkotlinmongo.dto.ApiResult
import com.abayu.yuhu.springkotlinmongo.services.UserService
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired private val userService: UserService
) {

    @PostMapping
    fun saveNewUser(@RequestBody user: User): ApiResult<User> {
        user.password = BCrypt.hashpw(user.password, BCrypt.gensalt())
        return userService.saveNewUser(user)
    }

    @GetMapping
    fun findAllUsers(): ApiResult<List<User>> {
        return userService.findAll()
    }

    @GetMapping("/{id}")
    fun getUserDetail(@PathVariable("id") id: String): ApiResult<User> {
        return userService.getUserDetail(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: String): ApiResult<String> {
        return userService.deleteUser(id)
    }

    @PutMapping
    fun updateUser(@RequestBody user: User): ResponseEntity<User> {
        return userService.updateUser(user)
    }
}