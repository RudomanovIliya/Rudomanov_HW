package com.example.hw_together.data.models

data class ApiRegisterUser(
    val phone: String,
    val passwordHashed: String,
    val name: String,
    val surname: String,
    val avatar: String,
)