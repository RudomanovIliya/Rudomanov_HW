package com.example.hw_together.ui.addnotescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.R
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomToolBarAddScreen(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LocalColors.current.yellow)
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .height(60.dp)
            .padding(start = 16.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = "Новая заметка",
            style = LocalTypography.current.titleHeader
        )
    }
}

@Preview
@Composable
fun CustomToolBarAddScreenPreview() {
    HW_TogetherTheme {
        CustomToolBarAddScreen()
    }
}