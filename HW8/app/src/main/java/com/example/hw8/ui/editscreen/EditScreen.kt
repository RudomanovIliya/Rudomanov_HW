package com.example.hw8.ui.editscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.hw8.ui.editscreen.components.EditScreenContent

@Composable
fun EditScreen(
    navController: NavController,
    textName: String,
    textSurname: String,
    textFathername: String,
    textBirthdayDate: String
) {
    EditScreenContent(
        navController = navController,
        textName = textName,
        textSurname = textSurname,
        textFathername = textFathername,
        textBirthdayDate = textBirthdayDate,
        onButtonClick = {
        }
    )
}