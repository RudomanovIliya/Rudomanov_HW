package com.example.hw_together.domain.repository

import com.example.hw_together.data.models.ApiResponseData
import com.example.hw_together.domain.models.AuthorizationLoginUser
import com.example.hw_together.domain.models.AuthorizationRegisterUser
import retrofit2.Response

interface AuthorizationRepository {
    suspend fun login(loginUser: AuthorizationLoginUser): Response<ApiResponseData>
    suspend fun register(registerUser: AuthorizationRegisterUser): Response<ApiResponseData>
}