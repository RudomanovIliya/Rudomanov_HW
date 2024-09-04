package com.example.hw_together.ui.navigation

import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.hw_together.ui.addnotescreen.AddNoteScreen
import com.example.hw_together.ui.addnotescreen.AddNoteScreenViewModel
import com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.AuthorizationLoginScreen
import dagger.hilt.android.lifecycle.HiltViewModel

const val ADD_NOTE_SCREEN_ROUTE = "add_screen_route"

fun NavController.navigateToAddNoteScreen(
) {
    this.navigate(ADD_NOTE_SCREEN_ROUTE) {
        popUpTo(0) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.addNoteScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp
) {
    composable(
        route = ADD_NOTE_SCREEN_ROUTE,
    ) {
        val viewModel: AddNoteScreenViewModel = hiltViewModel()
        AddNoteScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
            viewModel = viewModel
        )
    }
}