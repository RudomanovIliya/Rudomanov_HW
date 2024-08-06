package com.example.hw8.ui.mainscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.hw8.ui.mainscreen.components.MainScreenContent
import com.example.hw8.ui.navigation.navigateToProfileScreen


@Composable
fun MainScreen(
    navController: NavController,
) {
    MainScreenContent(
        onButtonClick = {
            navController.navigateToProfileScreen(
            )
        }
    )
}