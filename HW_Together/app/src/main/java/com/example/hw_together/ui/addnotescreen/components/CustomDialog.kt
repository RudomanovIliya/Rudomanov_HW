package com.example.hw_together.ui.addnotescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.hw_together.R
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomDialog(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onDismissRequest: () -> Unit,
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        containerColor = Color.White,
        shape = RoundedCornerShape(20.dp),
        onDismissRequest = onDismissRequest,
        confirmButton = {
            ButtonDialog(text = "Добавить", onClick = onAddClick)
        },
        dismissButton = {
            ButtonDialog(text = "Отмена", onClick = onCancelClick)
        },
        title = {
            Text(
                text = "Добавить фото",
                style = LocalTypography.current.titleDialog
            )
        },
        text = {
            CustomBasicTextFieldSubAddScreen(
                textStyle = LocalTypography.current.bodyDialog.copy(LocalColors.current.darkGray),
                value = value,
                defaultValue = "http://...",
                onValueChange = onValueChange
            )
        }
    )
}

@Composable
fun ButtonDialog(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Text(
        modifier = modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .clickable(onClick = onClick)
            .background(
                shape = RoundedCornerShape(6.dp),
                color = LocalColors.current.yellow
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        text = text,
        style = LocalTypography.current.bodyDialog.copy(color = Color.Black)
    )
}

@Composable
fun CustomErrorDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = modifier
                .height(248.dp)
                .width(314.dp)
                .background(
                    shape = RoundedCornerShape(20.dp),
                    color = LocalColors.current.lightBlack
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = null
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                text = "Упс, что-то пошло не так",
                style = LocalTypography.current.bigBody.copy(color = Color.White)
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 14.dp),
                text = "Попробуй снова",
                style = LocalTypography.current.bodyErrorDialog.copy(color = LocalColors.current.yellow)
            )
        }
    }
}

@Preview
@Composable
fun CustomDialogPreview() {
    HW_TogetherTheme {
//            CustomDialog(
//                value = "",
//                onValueChange = {},
//                onDismissRequest = {},
//                onAddClick = {},
//                onCancelClick = {})
        CustomErrorDialog(onDismissRequest = {})
    }
}