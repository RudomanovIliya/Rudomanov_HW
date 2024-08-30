package com.example.hw_together.data.repository

import com.example.hw_together.data.api.ApiAuthorization
import com.example.hw_together.data.models.ApiLoginUser
import com.example.hw_together.data.models.ApiRegisterUser
import com.example.hw_together.data.models.ApiResponseData
import com.example.hw_together.domain.models.AuthorizationLoginUser
import com.example.hw_together.domain.models.AuthorizationRegisterUser
import com.example.hw_together.domain.repository.AuthorizationRepository
import retrofit2.Response

class AuthorizationRepositoryImpl(
    private val apiAuthorization: ApiAuthorization
) : AuthorizationRepository {
    override suspend fun login(loginUser: AuthorizationLoginUser): Response<ApiResponseData> {

        return apiAuthorization.login(
            ApiLoginUser(
                loginUser.phone,
                loginUser.passwordHashed
            )
        )
    }

    override suspend fun register(registerUser: AuthorizationRegisterUser): Response<ApiResponseData> {
        return apiAuthorization.register(
            ApiRegisterUser(
                registerUser.phone,
                registerUser.passwordHashed,
                registerUser.name,
                registerUser.surname,
                registerUser.avatar
            )
        )
    }

}