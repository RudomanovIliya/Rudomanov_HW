package com.example.hw_together.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val MAIN_TAB_HOST_ROUTE = "main_tab_host_route"

fun NavController.navigateToMainTab() {
    this.navigate(MAIN_TAB_HOST_ROUTE) {
        popUpTo(0) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.mainTabHost(
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,

    ) {
    composable(
        route = MAIN_TAB_HOST_ROUTE,
    ) {
        val navController = rememberNavController()

        MainTabHost(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}

@Composable
private fun MainTabHost(
    navController: NavHostController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN_ROUTE,
    ) {
        mainScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}
