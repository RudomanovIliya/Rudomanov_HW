package com.example.hw8.ui.profilescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw8.ui.theme.CustomTypography
import com.example.hw8.ui.theme.HW8Theme
import com.example.hw8.ui.theme.LocalColors
import com.example.hw8.ui.theme.LocalTypography

@Composable
fun ProfileText(
    modifier: Modifier = Modifier,
    textTitle: String,
    text: String
) {
    Column(modifier = modifier) {
        Text(
            text = textTitle,
            style = LocalTypography.current.bodyMediumText,
            color = LocalColors.current.gray
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = text,
            style = LocalTypography.current.bodyMediumText
        )
    }
}

@Preview
@Composable
fun ProfileTextPreview() {
    HW8Theme {
        ProfileText(
            modifier = Modifier.background(Color.White),
            textTitle = "Город",
            text = "Саратов"
        )
    }
}