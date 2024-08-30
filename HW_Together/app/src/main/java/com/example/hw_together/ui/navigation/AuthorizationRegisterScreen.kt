package com.example.hw_together.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen.AuthorizationRegisterScreen

const val AUTHORIZATION_REGISTER_SCREEN_ROUTE = "authorization_register_screen_route"

fun NavController.navigateToRegisterScreen(
) {
    this.navigate(AUTHORIZATION_REGISTER_SCREEN_ROUTE)
}
fun NavGraphBuilder.authorizationRegisterScreen(
    navController: NavController,
) {
    composable(
        route = AUTHORIZATION_REGISTER_SCREEN_ROUTE,
    ) {
        AuthorizationRegisterScreen(
            navController = navController,
        )
    }
}