package com.example.hw8.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.hw8.ui.editscreen.EditScreen

const val EDIT_SCREEN_ROUTE = "edit_screen_route"
private const val NAME_KEY = "name_key"
private const val SURNAME_KEY = "surname_key"
private const val FATHERNAME_KEY = "fathername_key"
private const val BIRTHDAYDATE_KEY = "birthdaydate_key"


fun NavController.navigateToEditScreen(
    textName: String,
    textSurname: String,
    textFathername: String,
    textBirthdayDate: String
) {
    this.navigate("$EDIT_SCREEN_ROUTE/$textName/$textSurname/$textFathername/$textBirthdayDate")
}

fun NavGraphBuilder.editScreen(
    navController: NavController,
) {
    composable(
        route = "$EDIT_SCREEN_ROUTE/{$NAME_KEY}/{$SURNAME_KEY}/{$FATHERNAME_KEY}/{$BIRTHDAYDATE_KEY}",
        arguments = listOf(
            navArgument(NAME_KEY) {
                type = NavType.StringType
            },
            navArgument(SURNAME_KEY) {
                type = NavType.StringType
            },
            navArgument(FATHERNAME_KEY) {
                type = NavType.StringType
            },
            navArgument(BIRTHDAYDATE_KEY) {
                type = NavType.StringType
            },
        )
    ) { backStackEntry ->
        val textName = backStackEntry.arguments?.getString(NAME_KEY)
        val textSurname = backStackEntry.arguments?.getString(SURNAME_KEY)
        val textFathername = backStackEntry.arguments?.getString(FATHERNAME_KEY)
        val textBirthdayDate = backStackEntry.arguments?.getString(BIRTHDAYDATE_KEY)
        EditScreen(
            navController = navController,
            textName = textName ?: " ",
            textSurname = textSurname ?: " ",
            textFathername = textFathername ?: " ",
            textBirthdayDate = textBirthdayDate ?: " "
        )
    }
}