package com.example.hw8.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        mainScreen(
            navController = navController,
        )
        profileScreen(navController = navController)
        editScreen(navController = navController)
    }
}