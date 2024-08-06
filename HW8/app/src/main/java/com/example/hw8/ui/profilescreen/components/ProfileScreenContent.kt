package com.example.hw8.ui.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw8.R
import com.example.hw8.ui.components.CustomButton
import com.example.hw8.ui.components.MenuBar
import com.example.hw8.ui.theme.HW8Theme
import com.example.hw8.ui.theme.LocalColors

@Composable
fun ProfileScreenContent(
    onButtonClick: () -> Unit,
    textName: String,
    textSurname: String,
    textFathername: String,
    textBirthdayDate: String
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        MenuBar(
            modifier = Modifier.background(LocalColors.current.lightGray),
            text = stringResource(id = R.string.profile),
            isArrowBack = true
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LocalColors.current.lightGray),
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 20.dp, top = 30.dp, bottom = 30.dp)
                    .height(68.dp)
                    .width(64.dp),
                painter = painterResource(id = R.drawable.image),
                contentDescription = ""
            )
            ProfileCard(
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp),
                textName = textName,
                textSurname = textSurname,
                textFatherName = textFathername,
                textBirthdayDate = textBirthdayDate
            )
        }
        ProfileText(
            modifier = Modifier.padding(top = 24.dp, start = 16.dp),
            textTitle = stringResource(R.string.city),
            text = stringResource(R.string.saratov)
        )
        ProfileText(
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
            textTitle = stringResource(R.string.about),
            text = stringResource(R.string.wtf)
        )

        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            onClick = onButtonClick,
            modifier = Modifier
                .width(328.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            text = stringResource(R.string.edit_profile)
        )

    }
}


@Preview
@Composable
fun ProfileScreenContentPreview() {
    HW8Theme {
        ProfileScreenContent(textName = stringResource(id = R.string.ivan),
            textSurname = stringResource(id = R.string.ivanov),
            textFathername = stringResource(id = R.string.ivanovich),
            textBirthdayDate = stringResource(id = R.string._01_01_2001),
            onButtonClick = {})
    }
}