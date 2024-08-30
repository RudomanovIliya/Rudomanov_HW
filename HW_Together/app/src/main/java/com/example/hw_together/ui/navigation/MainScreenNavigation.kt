package com.example.hw_together.ui.navigation

import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw_together.ui.mainscreen.MainScreen

const val MAIN_SCREEN_ROUTE = "maine_screen_route"

fun NavController.navigateToMainScreen(
) {
    this.navigate(MAIN_SCREEN_ROUTE) {
        popUpTo(MAIN_SCREEN_ROUTE) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.mainScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp
) {
    composable(
        route = MAIN_SCREEN_ROUTE,
    ) {
        MainScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight
        )
    }
}