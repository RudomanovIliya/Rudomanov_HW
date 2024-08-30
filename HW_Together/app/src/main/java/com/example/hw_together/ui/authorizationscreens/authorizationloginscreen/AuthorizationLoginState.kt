package com.example.hw_together.ui.authorizationscreens.authorizationloginscreen

import com.example.hw_together.domain.models.AuthorizationLoginUser

data class AuthorizationLoginState (
    val authorizationLoginUser: AuthorizationLoginUser = AuthorizationLoginUser(
        "",
        ""
    ),
    val isRegister: Boolean = false,
    val isLoading: Boolean = false
)
