package com.example.hw_together.ui.splashscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.R
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors

@Composable
fun SplashScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LocalColors.current.yellow),
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.image_logo),
            contentDescription = ""
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            painter = painterResource(id = R.drawable.image_together),
            contentDescription = ""
        )
    }
}


@Preview
@Composable
fun SplashScreenContentPreview() {
    HW_TogetherTheme {
        SplashScreenContent()
    }
}