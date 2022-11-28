package com.tourguide.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val role: String,
    val photo: String,
)
