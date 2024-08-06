package com.example.hw8.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw8.ui.mainscreen.MainScreen

const val MAIN_SCREEN_ROUTE = "main_screen_route"

fun NavGraphBuilder.mainScreen(
    navController: NavController,
) {
    composable(
        route = MAIN_SCREEN_ROUTE,
    ) {
        MainScreen(
            navController = navController,
        )
    }
}