package com.example.hw_together.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen.AuthorizationRegisterScreen
import com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen.AuthorizationRegisterScreenViewModel

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
        val viewModel: AuthorizationRegisterScreenViewModel = hiltViewModel()
        AuthorizationRegisterScreen(
            navController = navController,
            viewModel = viewModel
        )
    }
}