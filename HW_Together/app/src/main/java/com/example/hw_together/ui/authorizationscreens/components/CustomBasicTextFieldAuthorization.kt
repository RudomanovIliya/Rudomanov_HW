package com.example.hw_together.ui.authorizationscreens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomBasicTextFieldAuthorization(
    modifier: Modifier = Modifier,
    value: String,
    defaultValue: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .height(36.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = LocalColors.current.transparentBlack
            ),
        textStyle = LocalTypography.current.bodyTextFieldAuthorization,
        value = value,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.padding(start = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = defaultValue,
                        style = LocalTypography.current.bodyTextFieldAuthorization
                    )
                }
                innerTextField()
            }
        },
    )
}

@Composable
fun CustomBasicTextFieldPassword(
    modifier: Modifier = Modifier,
    value: String,
    defaultValue: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .height(36.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = LocalColors.current.transparentBlack
            ),
        textStyle = LocalTypography.current.bodyTextFieldAuthorization,
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.padding(start = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                if (value.isEmpty()) {
                    Text(
                        text = defaultValue,
                        style = LocalTypography.current.bodyTextFieldAuthorization
                    )
                }
                innerTextField()
                IconButton(modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = image, null, modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                }
            }
        },
    )
}


@Preview
@Composable
fun CustomBasicTextFieldPreview() {
    HW_TogetherTheme {
        CustomBasicTextFieldPassword(
            modifier = Modifier.background(color = LocalColors.current.yellow),
            value = "",
            defaultValue = "1234",
            onValueChange = {}
        )
    }
}