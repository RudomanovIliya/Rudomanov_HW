package com.example.hw_together.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.AuthorizationLoginScreen
import com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.AuthorizationLoginScreenViewModel

const val AUTHORIZATION_LOGIN_SCREEN_ROUTE = "authorization_login_screen_route"

fun NavController.navigateToLoginScreen(
) {
    this.navigate(AUTHORIZATION_LOGIN_SCREEN_ROUTE){
        popUpTo(0){
            saveState=true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.authorizationLoginScreen(
    navController: NavController,
) {
    composable(
        route = AUTHORIZATION_LOGIN_SCREEN_ROUTE,
    ) {
        val viewModel: AuthorizationLoginScreenViewModel = hiltViewModel()
        AuthorizationLoginScreen(
            navController = navController,
            viewModel = viewModel
        )
    }
}