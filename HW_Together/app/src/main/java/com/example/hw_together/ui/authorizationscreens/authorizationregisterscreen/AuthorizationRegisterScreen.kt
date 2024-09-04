package com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hw_together.ui.navigation.navigateToLoginScreen
import com.example.hw_together.ui.navigation.navigateToMainScreen
import com.example.hw_together.ui.navigation.navigateToMainTab
import com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen.components.AuthorizationRegisterScreenContent
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun AuthorizationRegisterScreen(
    navController: NavController,
    viewModel: AuthorizationRegisterScreenViewModel
) {
    val state = viewModel.collectAsState().value
    if (state.isRegister) {
        navController.navigateToMainTab()
    }
    AuthorizationRegisterScreenContent(
        onClickLogin = { navController.navigateToLoginScreen() }, viewModel = viewModel
    )
}