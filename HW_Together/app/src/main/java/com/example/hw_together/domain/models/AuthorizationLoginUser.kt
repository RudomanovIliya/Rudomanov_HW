package com.example.hw_together.domain.models

data class AuthorizationLoginUser(
    val phone: String,
    val passwordHashed: String,
)