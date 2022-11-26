package com.tourguide.data.dto

import com.tourguide.domain.model.User

data class UserDto(
    val _id: String,
    val email: String,
    val name: String,
    val role: String
)

fun UserDto.toUser(): User {
    return User(
        id = _id,
        email = email,
        name = name,
        role = role,
    )
}
