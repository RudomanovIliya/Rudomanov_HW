package com.example.hw8.ui.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw8.R
import com.example.hw8.ui.theme.HW8Theme
import com.example.hw8.ui.theme.LocalTypography

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    textName: String,
    textSurname: String,
    textFatherName: String,
    textBirthdayDate: String
) {
    Row(
        modifier = modifier
            .background(shape = RoundedCornerShape(12.dp), color = Color.White)
            .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp)
    ) {
        Column() {
            Text(
                text = textName,
                style = LocalTypography.current.bodyMedium
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = textSurname, style = LocalTypography.current.bodyMedium
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = textFatherName, style = LocalTypography.current.bodyMedium
            )
        }
        Column(modifier = Modifier.padding(start = 80.dp)) {
            Text(
                text = stringResource(R.string.text_birtday_day),
                style = LocalTypography.current.bodySmall
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = textBirthdayDate, style = LocalTypography.current.bodySmall
            )
        }
    }

}

@Preview
@Composable
fun ProfileCardPreview() {
    HW8Theme {
        ProfileCard(
            textName = "Иван",
            textSurname = "Иванов",
            textFatherName = "Иванович",
            textBirthdayDate = "01.01.2001"
        )
    }
}