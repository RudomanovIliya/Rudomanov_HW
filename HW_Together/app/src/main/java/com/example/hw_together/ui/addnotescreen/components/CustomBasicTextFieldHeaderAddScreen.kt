package com.example.hw_together.ui.addnotescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomBasicTextFieldHeaderAddScreen(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    Row(modifier = modifier) {
        Spacer(
            modifier = Modifier
                .width(2.dp)
                .height(34.dp)
                .background(color = LocalColors.current.gray)
        )
        BasicTextField(
            modifier = Modifier.padding(start = 12.dp),
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTypography.current.noteHeader
        )
    }
}

@Composable
fun CustomBasicTextFieldSubAddScreen(
    modifier: Modifier = Modifier
) {

}

@Preview
@Composable
fun CustomBasicTextFieldAddScreenPreview() {
    HW_TogetherTheme {
        Column {
            CustomBasicTextFieldHeaderAddScreen(value = "AfF23", onValueChange = {})
            CustomBasicTextFieldSubAddScreen()
        }

    }
}