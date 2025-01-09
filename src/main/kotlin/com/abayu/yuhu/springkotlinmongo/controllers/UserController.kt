package com.abayu.yuhu.springkotlinmongo.controllers

import com.abayu.yuhu.springkotlinmongo.documents.User
import com.abayu.yuhu.springkotlinmongo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val userService: UserService) {

    @PostMapping
    fun saveNewUser(@RequestBody user: User): User {
        return userService.saveNewUser(user)
    }

    @GetMapping
    fun findAllUsers(): List<User> {
        return userService.findAll()
    }

    @GetMapping("/{id}")
    fun getUserDetail(@PathVariable("id") id: String): ResponseEntity<User> {
        return userService.getUserDetail(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: String) {
        return userService.deleteUser(id)
    }

    @PutMapping
    fun updateUser(@RequestBody user: User): ResponseEntity<User> {
        return userService.updateUser(user)
    }
}