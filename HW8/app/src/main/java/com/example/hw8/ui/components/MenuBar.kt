package com.example.hw8.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw8.R
import com.example.hw8.ui.theme.HW8Theme
import com.example.hw8.ui.theme.LocalTypography

@Composable
fun MenuBar(
    modifier: Modifier = Modifier,
    text: String,
    isArrowBack: Boolean = false
) {
    Column(modifier = modifier.height(56.dp)) {
        var padding = 0.dp
        Row(
            modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        ) {
            if (isArrowBack) {
                padding = 37.dp
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(start = padding),
                text = text,
                style = LocalTypography.current.title
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(Color.Black)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun MenuBarPreview() {
    HW8Theme {
        MenuBar(modifier = Modifier.background(Color.White), text = "test", isArrowBack = true)
    }
}