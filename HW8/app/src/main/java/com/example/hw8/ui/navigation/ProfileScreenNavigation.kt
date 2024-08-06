package com.example.hw8.ui.navigation

import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.hw8.R
import com.example.hw8.ui.profilescreen.ProfileScreen

const val PROFILE_SCREEN_ROUTE = "profile_screen_route"
private const val NAME_KEY = "name_key"
private const val SURNAME_KEY = "surname_key"
private const val FATHERNAME_KEY = "fathername_key"
private const val BIRTHDAYDATE_KEY = "birthdaydate_key"

fun NavController.navigateToProfileScreen(
) {
    this.navigate(PROFILE_SCREEN_ROUTE)
}

fun NavGraphBuilder.profileScreen(
    navController: NavController,
) {
    composable(
        route = PROFILE_SCREEN_ROUTE,
    ) { backStackEntry ->
        val textName = backStackEntry.savedStateHandle.get<String>(NAME_KEY)
        val textSurname = backStackEntry.savedStateHandle.get<String>(SURNAME_KEY)
        val textFathername = backStackEntry.savedStateHandle.get<String>(FATHERNAME_KEY)
        val textBirthdayDate = backStackEntry.savedStateHandle.get<String>(BIRTHDAYDATE_KEY)
        ProfileScreen(
            navController = navController,
            textName = textName ?: stringResource(id = R.string.ivan),
            textSurname = textSurname ?: stringResource(id = R.string.ivanov),
            textFathername = textFathername ?: stringResource(id = R.string.ivanovich),
            textBirthdayDate = textBirthdayDate ?: stringResource(id = R.string._01_01_2001),
        )
    }
}