package com.example.hw_together.domain.models

data class AuthorizationRegisterUser(
    val phone: String,
    val passwordHashed: String,
    val name: String,
    val surname: String,
    val avatar: String,
)