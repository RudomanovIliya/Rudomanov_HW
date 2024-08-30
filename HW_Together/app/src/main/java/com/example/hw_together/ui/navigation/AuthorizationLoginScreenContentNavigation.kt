package com.example.hw_together.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.AuthorizationLoginScreen

const val AUTHORIZATION_LOGIN_SCREEN_ROUTE = "authorization_login_screen_route"

fun NavController.navigateToLoginScreen(
) {
    this.navigate(AUTHORIZATION_LOGIN_SCREEN_ROUTE)
}

fun NavGraphBuilder.authorizationLoginScreen(
    navController: NavController,
) {
    composable(
        route = AUTHORIZATION_LOGIN_SCREEN_ROUTE,
    ) {
        AuthorizationLoginScreen(
            navController = navController,
        )
    }
}