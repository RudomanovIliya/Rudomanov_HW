package com.example.hw_together.data.models

data class ApiResponseData(
    val data: ApiResponseToken?,
)

data class ApiResponseToken(
    val token: String?,
)
