package com.tourguide.data.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("_id")
    val id: String,
    val email: String,
    val name: String,
    val role: String
)