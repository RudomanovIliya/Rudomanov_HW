package com.example.hw_together.ui.addnotescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomBasicTextFieldHeaderAddScreen(
    modifier: Modifier = Modifier,
    value: String,
    defaultValue: String,
    onValueChange: (String) -> Unit
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier
                .width(2.dp)
                .height(34.dp)
                .background(color = LocalColors.current.gray)
        )
        BasicTextField(
            modifier = Modifier.padding(start = 12.dp),
            singleLine = true,
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTypography.current.noteHeader,
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(text = defaultValue, style = LocalTypography.current.noteHeader)
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun CustomBasicTextFieldSubAddScreen(
    modifier: Modifier = Modifier,
    value: String,
    defaultValue: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = LocalTypography.current.subHeaderAuthorization.copy(color = LocalColors.current.darkGray)
) {
    Row(modifier = modifier.fillMaxWidth()) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = defaultValue,
                        color = LocalColors.current.darkGray,
                        style = LocalTypography.current.subHeaderAuthorization
                    )
                }
                innerTextField()
            }
        )
    }

}

@Preview
@Composable
fun CustomBasicTextFieldAddScreenPreview() {
    HW_TogetherTheme {
        Column {
            CustomBasicTextFieldHeaderAddScreen(
                value = "",
                defaultValue = "default",
                onValueChange = {})
            CustomBasicTextFieldSubAddScreen(value = "1234", defaultValue = "", onValueChange = {})
        }

    }
}