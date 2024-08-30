package com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen

import android.content.Context
import com.example.hw_together.domain.models.AuthorizationRegisterUser

data class AuthorizationRegisterState(
    val authorizationRegisterUser: AuthorizationRegisterUser = AuthorizationRegisterUser(
        "",
        "",
        "",
        "",
        ""
    ),
    val isRegister: Boolean = false,
    val isLoading: Boolean = false
)