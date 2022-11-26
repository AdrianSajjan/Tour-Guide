package com.tourguide.data.dto

import com.tourguide.domain.model.Tokens

data class TokensDto (
    val accessToken: String,
    val refreshToken: String,
)

fun TokensDto.toTokens():Tokens {
    return Tokens(
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}