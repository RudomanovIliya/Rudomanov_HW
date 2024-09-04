package com.example.hw_together.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = ""
        val requestBuilder = chain.request().newBuilder().addHeader("BearerAuth", "Bearer $token")
        return chain.proceed(request = requestBuilder.build())
    }
}