package com.example.hw_together.data.repository

import com.example.hw_together.data.api.ApiRequests
import com.example.hw_together.data.models.ApiLoginUser
import com.example.hw_together.data.models.ApiRegisterUser
import com.example.hw_together.data.models.ApiResponseData
import com.example.hw_together.domain.models.AuthorizationLoginUser
import com.example.hw_together.domain.models.AuthorizationRegisterUser
import com.example.hw_together.domain.repository.AuthorizationRepository
import retrofit2.Response
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val apiRequests: ApiRequests
) : AuthorizationRepository {
    override suspend fun login(loginUser: AuthorizationLoginUser): Response<ApiResponseData> {

        return apiRequests.login(
            ApiLoginUser(
                phone = loginUser.phone,
                passwordHashed = loginUser.passwordHashed
            )
        )
    }

    override suspend fun register(registerUser: AuthorizationRegisterUser): Response<ApiResponseData> {
        return apiRequests.register(
            ApiRegisterUser(
                phone = registerUser.phone,
                passwordHashed = registerUser.passwordHashed,
                name = registerUser.name,
                surname = registerUser.surname,
                avatar = registerUser.avatar
            )
        )
    }

}