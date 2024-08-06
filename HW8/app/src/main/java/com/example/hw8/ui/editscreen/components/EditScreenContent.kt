package com.example.hw8.ui.editscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hw8.R
import com.example.hw8.ui.components.CustomButton
import com.example.hw8.ui.components.MenuBar
import com.example.hw8.ui.theme.HW8Theme
import com.example.hw8.ui.theme.LocalTypography

private const val NAME_KEY = "name_key"
private const val SURNAME_KEY = "surname_key"
private const val FATHERNAME_KEY = "fathername_key"
private const val BIRTHDAYDATE_KEY = "birthdaydate_key"

@Composable
fun EditScreenContent(
    navController: NavController,
    onButtonClick: () -> Unit,
    textName: String,
    textSurname: String,
    textFathername: String,
    textBirthdayDate: String
) {
    var textNameArg by rememberSaveable { mutableStateOf(textName) }
    var textSurnameArg by rememberSaveable { mutableStateOf(textSurname) }
    var textFathernameArg by rememberSaveable { mutableStateOf(textFathername) }
    var texBirthdayDateArg by rememberSaveable { mutableStateOf(textBirthdayDate) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

        MenuBar(text = stringResource(R.string.editing_profile), isArrowBack = true)
        Row(modifier = Modifier.padding(top = 20.dp, start = 16.dp)) {
            Text(text = stringResource(R.string.name), style = LocalTypography.current.title)
            BasicTextField(
                value = textNameArg,
                onValueChange = { textNameArg = it },
                textStyle = LocalTypography.current.title
            )
        }
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Text(text = stringResource(R.string.surname), style = LocalTypography.current.title)
            BasicTextField(
                value = textSurnameArg,
                onValueChange = { textSurnameArg = it },
                textStyle = LocalTypography.current.title
            )
        }
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Text(text = stringResource(R.string.father_name), style = LocalTypography.current.title)
            BasicTextField(
                value = textFathernameArg,
                onValueChange = { textFathernameArg = it },
                textStyle = LocalTypography.current.title
            )
        }
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Text(
                text = stringResource(id = R.string.text_birtday_day),
                style = LocalTypography.current.title
            )
            BasicTextField(
                value = texBirthdayDateArg,
                onValueChange = { texBirthdayDateArg = it },
                textStyle = LocalTypography.current.title
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            modifier = Modifier
                .width(328.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp), text = "Сохранить",
            onClick = {
                navController.popBackStack()
                navController.currentBackStackEntry?.savedStateHandle?.set(NAME_KEY, textNameArg)
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    SURNAME_KEY,
                    textSurnameArg
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    FATHERNAME_KEY,
                    textFathernameArg
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    BIRTHDAYDATE_KEY,
                    texBirthdayDateArg
                )
                onButtonClick()
            }
        )
    }
}

@Preview
@Composable
fun EditScreenContentPreview() {
    HW8Theme {
//        EditScreenContent(
//            textName = stringResource(id = R.string.ivan),
//            textSurname = stringResource(id = R.string.ivanov),
//            textFathername = stringResource(id = R.string.ivanovich),
//            textBirthdayDate = stringResource(id = R.string._01_01_2001),
//            onButtonClick = {}
//        )
    }
}