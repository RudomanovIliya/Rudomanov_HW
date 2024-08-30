package com.example.hw_together.ui.authorizationscreens.authorizationloginscreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hw_together.ui.navigation.navigateToMainScreen
import com.example.hw_together.ui.navigation.navigateToMainTab
import com.example.hw_together.ui.navigation.navigateToRegisterScreen
import com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.components.AuthorizationLoginScreenContent
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun AuthorizationLoginScreen(
    navController: NavController,
) {
    val viewModel: AuthorizationLoginScreenViewModel = hiltViewModel()
    val state = viewModel.collectAsState().value
    if (state.isRegister) {
        navController.navigateToMainTab()
    }
    AuthorizationLoginScreenContent(
        onClickRegister = { navController.navigateToRegisterScreen() })
}