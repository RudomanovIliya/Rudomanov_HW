package com.example.hw_together.domain.usecases

import com.example.hw_together.data.models.ApiResponseData
import com.example.hw_together.domain.models.AuthorizationLoginUser
import com.example.hw_together.domain.models.AuthorizationRegisterUser
import com.example.hw_together.domain.repository.AuthorizationRepository
import retrofit2.Response

class LoginUseCase(
    private val authorizationRepository: AuthorizationRepository
) {
    suspend operator fun invoke(authorizationLoginUser: AuthorizationLoginUser): Response<ApiResponseData> {
        return authorizationRepository.login(authorizationLoginUser)
    }
}