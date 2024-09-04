package com.example.hw_together.domain.usecases

import com.example.hw_together.data.models.ApiResponseData
import com.example.hw_together.domain.models.AuthorizationRegisterUser
import com.example.hw_together.domain.repository.AuthorizationRepository
import retrofit2.Response
import javax.inject.Inject

class RegisterUseCase(
    private val authorizationRepository: AuthorizationRepository
) {
    suspend operator fun invoke(authorizationRegisterUser: AuthorizationRegisterUser): Response<ApiResponseData> {
        return authorizationRepository.register(authorizationRegisterUser)
    }
}