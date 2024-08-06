package com.example.hw8.ui.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw8.R
import com.example.hw8.ui.components.CustomButton
import com.example.hw8.ui.components.MenuBar
import com.example.hw8.ui.theme.HW8Theme

@Composable
fun MainScreenContent(
    onButtonClick: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        MenuBar(text = stringResource(R.string.main))
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            onClick = onButtonClick,
            modifier = Modifier
                .width(328.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            text = stringResource(R.string.profile)
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    HW8Theme {
        MainScreenContent {}
    }
}