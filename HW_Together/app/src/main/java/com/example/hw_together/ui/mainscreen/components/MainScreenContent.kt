package com.example.hw_together.ui.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.LocalColors

@Composable
fun MainScreenContent() {
    if (false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .safeDrawingPadding(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(56.dp)
                    .width(56.dp),
                color = LocalColors.current.yellow
            )
        }
    } else {
        Column(Modifier.fillMaxSize()) {
            CustomToolBarMain()
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 20.dp)
            ) {
                CustomHeader(text = "Ваши курсы", onClick = {})
                Spacer(modifier = Modifier.height(182.dp))//для будущего пейджера
                CustomHeader(
                    modifier = Modifier.padding(top = 24.dp),
                    text = "Ваши заметки",
                    onClick = {})
                CustomNote(
                    modifier = Modifier.padding(top = 12.dp),
                    dateText = "12 июля",
                    titleText = "Для создания новой Activity",
                    bodyText = "Нужно лишь применить старый дедовский визард"
                )
                CustomHeader(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Заметки сообщества",
                    onClick = {})
                CustomNote(
                    modifier = Modifier.padding(top = 12.dp),
                    dateText = "12 июля",
                    titleText = "Тест для текста в несколько строк. Это очень важно оооооо",
                    bodyText = "нь важный момент. Его нужно проверять постоянно оооооооо"
                )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}