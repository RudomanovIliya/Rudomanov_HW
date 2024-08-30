package com.example.hw_together.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,

        ) {
        authorizationLoginScreen(
            navController = navController,
        )
        authorizationRegisterScreen(
            navController = navController
        )
        mainTabHost(
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight
        )
//        mainScreen(
//            navController = navController,
//            setBottomBarVisibility = setBottomBarVisibility,
//            bottomBarHeight = bottomBarHeight
//        )
        addNoteScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight
        )
    }
}