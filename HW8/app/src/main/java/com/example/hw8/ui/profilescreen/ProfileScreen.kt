package com.example.hw8.ui.profilescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.hw8.ui.navigation.navigateToEditScreen
import com.example.hw8.ui.profilescreen.components.ProfileScreenContent

@Composable
fun ProfileScreen(
    navController: NavController,
    textName: String,
    textSurname: String,
    textFathername: String,
    textBirthdayDate: String
) {
    ProfileScreenContent(
        textName = textName,
        textSurname = textSurname,
        textFathername = textFathername,
        textBirthdayDate = textBirthdayDate,
        onButtonClick = {
            navController.navigateToEditScreen(
                textName = textName,
                textSurname = textSurname,
                textFathername = textFathername,
                textBirthdayDate = textBirthdayDate
            )
        }
    )
}