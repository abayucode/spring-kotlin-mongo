package com.abayu.yuhu.springkotlinmongo.services

import com.abayu.yuhu.springkotlinmongo.documents.User
import com.abayu.yuhu.springkotlinmongo.dto.ApiResult
import com.abayu.yuhu.springkotlinmongo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun saveNewUser(user: User): ApiResult<User> {
        userRepository.insert(user)
        return ApiResult<User>().success(user);
    }

    override fun findAll(): ApiResult<List<User>> {
        return ApiResult<List<User>>().success(userRepository.findAll())
    }

    override fun getUserDetail(id: String): ApiResult<User> {
        val user = userRepository.findById(id)

        return if (user.isEmpty) ApiResult<User>()
            .failure("Data with id $id not found")
        else return ApiResult<User>().success(user.get())
    }

    override fun deleteUser(id: String): ApiResult<String> {
        return ApiResult<String>().success("")
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