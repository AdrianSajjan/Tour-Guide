package com.tourguide.domain.model

import java.util.Date

data class Review(
    val id: String,
    val review: String,
    val rating: Double,
    val createdAt: Date,
    val tour: Tour,
    val user: User,
)
