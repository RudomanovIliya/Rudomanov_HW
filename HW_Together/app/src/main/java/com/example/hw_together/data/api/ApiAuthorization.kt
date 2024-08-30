package com.example.hw_together.data.api

import com.example.hw_together.data.models.ApiLoginUser
import com.example.hw_together.data.models.ApiRegisterUser
import com.example.hw_together.data.models.ApiResponseData
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiAuthorization {

    @POST("/api/auth")
    suspend fun login(@Body body: ApiLoginUser?): retrofit2.Response<ApiResponseData>

    @POST("/api/register")
    suspend fun register(@Body body: ApiRegisterUser?): retrofit2.Response<ApiResponseData>

}