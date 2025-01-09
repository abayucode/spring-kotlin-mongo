package com.abayu.yuhu.springkotlinmongo.documents

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document("user_collections")
data class User(
    @Id
    var id:String = ObjectId().toString(),
    var username: String?,
    var password: String?,
    var fullName: String?,
    var address: Address?,
    var profession: Profession?,
)

data class Address(
    val street: String,
    val city: String,
    val province: String,
    val zipCode: String,
)

data class Profession(
    val jobName: String,
    val companyName: String,
    val salary: BigDecimal
)
